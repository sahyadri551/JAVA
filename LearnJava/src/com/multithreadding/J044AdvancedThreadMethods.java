package com.multithreadding;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// ==========================================
// THE WAIT & NOTIFY PATTERN (Producer-Consumer)
// ==========================================
class MessageQueue {
    /**
     * You need to know how wait() and notifyAll()
     * work to pass a Java interview. However, in a
     * professional enterprise environment, we almost
     * never write them manually. If you need a thread-safe
     * Queue where Producers wait when it's full and Consumers
     * wait when it's empty, you use
     * java.util.concurrent.BlockingQueue
     * (like ArrayBlockingQueue). The Java architects already
     * wrote the wait/notify logic inside those classes
     * flawlessly so you don't have to risk causing a deadlock.
     */
    private final Queue<String> queue = new LinkedList<>();
    private final int MAX_CAPACITY = 5;

    // wait() and notifyAll() MUST be called from inside a synchronized context.
    // If you don't own the monitor lock, Java throws IllegalMonitorStateException.

    public synchronized void produce(String message) throws InterruptedException {
        // Always use a 'while' loop with wait(), NEVER an 'if' statement.
        // Threads can experience "spurious wakeup" (waking up without notifying).
        while (queue.size() == MAX_CAPACITY) {
            System.out.println("Queue full. Producer waiting...");
            wait(); // 1. Releases the lock on MessageQueue and goes to sleep.
        }

        queue.add(message);
        System.out.println("Produced: " + message);

        // 2. Wakes up ALL threads currently waiting on this object's lock.
        notifyAll();
    }

    public synchronized String consume() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("Queue empty. Consumer waiting...");
            wait(); // Releases lock, waits for a producer to add something.
        }

        String message = queue.poll();
        System.out.println("Consumed: " + message);

        // Wakes up producers who might be waiting because the queue was full.
        notifyAll();
        return message;
    }
}

public class J044AdvancedThreadMethods {
    static void main() {

        // ==========================================
        // FIXING THE EXECUTOR SERVICE WARNING
        // ==========================================
        // Modern Java (19+): Using try-with-resources.
        // This automatically calls close() -> shutdown() -> awaitTermination().
        try (ExecutorService pool = Executors.newFixedThreadPool(3)) {

            MessageQueue sharedQueue = new MessageQueue();

            // Task 1: The Producer
            pool.submit(() -> {
                try {
                    for (int i = 1; i <= 5; i++) {
                        sharedQueue.produce("Data " + i);

                        // SLEEP EXPLANATION:
                        // Pauses execution but DOES NOT release locks.
                        // Here, it is outside the synchronized block, so it's safe.
                        Thread.sleep(500);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            // Task 2: The Consumer
            pool.submit(() -> {
                try {
                    for (int i = 1; i <= 5; i++) {
                        sharedQueue.consume();
                        Thread.sleep(800);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            // Task 3: The Yield Test
            pool.submit(() -> {
                for (int i = 0; i < 3; i++) {
                    System.out.println("Yield Thread doing low priority work...");
                    // YIELD EXPLANATION:
                    // Tells the OS: "I have CPU time, but I don't really need it right now.
                    // Let someone else run if they want."
                    // The OS scheduler can (and usually does) completely ignore this.
                    Thread.yield();
                }
            });

        } // <-- The pool is automatically shut down safely right here.
        System.out.println("All tasks finished and pool closed.");
    }
}

/*
 * The Pros and Cons (The Architect's Guide)
 * 1. Thread.sleep(ms)
 * What it does: Pauses the thread for a specified time.
 * Pros: Easy to use for simulating delays, polling an external API with rate limits, or creating basic visual pauses.
 * Cons: It does not release monitor locks. If you call sleep() inside a synchronized method, you freeze the entire system because no other thread can get the lock until the sleep finishes. Professional code prefers ScheduledExecutorService over raw sleep() for timed tasks.
 * 2. Thread.yield()
 * What it does: A polite hint to the OS scheduler that the current thread is willing to yield its current use of a processor.
 * Pros: Theoretically useful in custom "spin-locks" (where a thread loops infinitely checking a variable) to prevent it from burning 100% of the CPU while spinning.
 * Cons: It is practically useless in modern programming. Java explicitly states there are no guarantees the OS will listen to it. Never use yield() to control the logical flow of your application.
 * 3. wait()
 * What it does: Forces the thread to give up its lock on the object and go to sleep until another thread calls notify().
 * Pros: The foundation of thread communication. It prevents CPU-burning "busy waiting" (where a thread loops infinitely checking if (queue.isEmpty())).
 * Cons: Highly prone to deadlocks if you screw up the logic. You must handle InterruptedException, and you must call it inside a while loop to prevent spurious wakeup.
 * 4. notify()
 * What it does: Wakes up exactly one random thread currently waiting on the object.
 * Pros: Slightly more efficient than notifyAll() because it doesn't cause a "Thundering Herd" (where 50 threads wake up, fight for the lock, and 49 go immediately back to sleep).
 * Cons: Dangerous. If you have multiple consumer threads and multiple producer threads, notify() might wake up the wrong type of thread. A producer might wake up another producer instead of a consumer, causing the entire system to stall forever.
 * 5. notifyAll()
 * What it does: Wakes up all threads waiting on the object.
 * Pros: The safest way to do inter-thread communication. It guarantees that the correct thread will eventually get the lock and make progress.
 * Cons: Causes minor performance overhead because all waiting threads wake up and compete for the CPU, even if only one can actually proceed.
 */