package com.multithreadding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// 1. A simple task that takes some time
class WorkerTask implements Runnable {
    private final int taskId;

    public WorkerTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Executing Task " + taskId + " via " + Thread.currentThread().getName());
        try {
            // Simulate work
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Task " + taskId + " interrupted.");
        }
    }
}

public class J043ThreadPool {
    static void main() {

        // 2. Create a Pool of exactly 3 reusable threads
        ExecutorService pool = Executors.newFixedThreadPool(3);

        System.out.println("Submitting 10 tasks to a pool of 3 threads...");

        // 3. Submit 10 tasks. We DO NOT create 10 threads.
        for (int i = 1; i <= 10; i++) {
            pool.submit(new WorkerTask(i));
        }

        // 4. Shut down the pool.
        // This does NOT stop running tasks. It just prevents new tasks from being added.
        pool.shutdown();

        // 5. Tell the main thread to wait for the pool to finish all tasks (like join)
        try {
            // Wait a maximum of 1 minute for everything to finish
            if (pool.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("All tasks completed successfully.");
            } else {
                System.out.println("Timeout reached. Tasks are still running.");
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
    }
}