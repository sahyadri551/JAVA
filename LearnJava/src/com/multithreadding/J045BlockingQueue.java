package com.multithreadding;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Producer implements Runnable {
    /**
     * The Two Implementations You Actually Use
     * ArrayBlockingQueue: Backed by an array. You must give it a fixed capacity (e.g., new ArrayBlockingQueue<>(100)). This is the best choice for stability. It mathematically guarantees your producers cannot flood the server and cause an OutOfMemoryError.
     * LinkedBlockingQueue: Backed by a linked list. If you don't give it a capacity, it defaults to Integer.MAX_VALUE (2 billion). Use this only if you absolutely need an unbounded queue, and you trust your consumers to process data faster than producers create it.
     */
    private final BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                String message = "Data Payload " + i;
                System.out.println("Producer attempting to send: " + message);

                // THE MAGIC: If the queue is full, the thread automatically freezes here.
                // It will wake up the exact millisecond a consumer takes an item.
                queue.put(message);

                System.out.println("Producer successfully sent: " + message);
            }
        } catch (InterruptedException e) {
            System.out.println("Producer interrupted. Shutting down.");
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer implements Runnable {
    private final BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Consumer waiting for data...");

                // THE MAGIC: If the queue is empty, the thread automatically freezes here.
                // It will wake up the exact millisecond a producer puts an item in.
                String message = queue.take();

                System.out.println("Consumer processed: " + message);
                Thread.sleep(1000); // Simulating heavy processing time
            }
        } catch (InterruptedException e) {
            System.out.println("Consumer interrupted. Shutting down.");
            Thread.currentThread().interrupt();
        }
    }
}

public class J045BlockingQueue {
    static void main() {

        // 1. Create a queue with a strict maximum capacity of 2 items.
        // This forces the producer to wait if it gets too far ahead.
        BlockingQueue<String> sharedQueue = new ArrayBlockingQueue<>(2);

        // 2. Launch the threads using try-with-resources
        try (ExecutorService pool = Executors.newFixedThreadPool(2)) {
            pool.submit(new Producer(sharedQueue));
            pool.submit(new Consumer(sharedQueue));
        }

        System.out.println("System shutdown complete.");
    }
}