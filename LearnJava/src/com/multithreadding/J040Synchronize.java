package com.multithreadding;

class Counter {
    /**
     * to fix the "naked read" vulnerability, we can use 'volatile' and 'synchronized' together.
     * class Counter {
     *     // 'volatile' tells the CPU: "Do NOT cache this in L1/L2.
     *     // Always read from and write directly to main RAM."
     *     private volatile int count = 0;
     *     public synchronized void increment() {
     *         count++; // Synchronized prevents the race condition
     *     }
     *     public int getCount() {
     *         return count; // Volatile guarantees you see the freshest RAM value
     *     }
     * }
     */
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

class CounterThread implements Runnable {
    private final Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            counter.increment();
        }
    }
}

public class J040Synchronize {
    static void main() {
        Counter counter = new Counter();
        Thread t1 = new Thread(new CounterThread(counter));
        Thread t2 = new Thread(new CounterThread(counter));
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }

        System.out.println("Counter value: " + counter.getCount());
    }
}