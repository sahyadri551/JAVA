package com.multithreadding;

// 1. Implement Runnable, do not extend Thread
class Task1 implements Runnable {
    @Override
      public void run() {
        int sum=0;
        for (int i = 0; i < 5000; i++) {
            sum+=i;
        }
        System.out.println("\nTask1: Done"+sum+Thread.currentThread().getName());
    }
}

class Task2 implements Runnable {
    @Override
    public void run() {
        int sum=0;
        for (int i = 0; i < 5000; i++) {
            sum+=i;
        }
        System.out.println("\nTask2: Done"+sum+Thread.currentThread().getName());
    }
}

class Task3 implements Runnable {
    @Override
    public void run() {
        int sum=0;
        for (int i = 0; i < 5000; i++) {
            sum+=i;
        }
        System.out.println("\nTask3: Done"+sum+Thread.currentThread().getName());
    }
}

public class J038Multithreading1 {
    public static void main(String[] args) {

        // 2. Pass the Runnable into new Thread objects
        Thread t1 = new Thread(new Task1());
        Thread t2 = new Thread(new Task2());
        Thread t3 = new Thread(new Task3());

        long startTime = System.currentTimeMillis();

        t1.start();
        t2.start();
        t3.start();

        // 3. Force the main thread to WAIT for t1, t2, and t3 to die
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }

        long endTime = System.currentTimeMillis();

        // 4. Now the time is accurate.
        System.out.println("\n\nTime Taken : " + (endTime - startTime) + " ms"+Thread.currentThread().getName());
    }
}