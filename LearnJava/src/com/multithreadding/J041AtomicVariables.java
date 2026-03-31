package com.multithreadding;

import java.util.concurrent.atomic.AtomicInteger;

class Counter2 {
    // 1. Replace the primitive 'int' with an AtomicInteger
    private final AtomicInteger count = new AtomicInteger(0);

    // 2. No 'synchronized' keyword is needed. No locks. No waiting.
    public void increment() {
        count.incrementAndGet(); // This is mathematically guaranteed to be thread-safe
    }

    // 3. The read operation is also mathematically safe and guaranteed to be fresh
    public int getCount() {
        return count.get();
    }
}

class CounterThread2 implements Runnable {
    private final Counter2 counter;

    public CounterThread2(Counter2 counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            counter.increment();
        }
    }
}

public class J041AtomicVariables {
    static void main() {
        Counter2 counter1 = new Counter2();
        Thread t1 = new Thread(new CounterThread2(counter1));
        Thread t2 = new Thread(new CounterThread2(counter1));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }

        System.out.println("Counter value: " + counter1.getCount()); // Exactly 20,000
    }
}