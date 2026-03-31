package com.multithreadding.ExecuterService;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

class PrintTask2 implements Runnable {
    private final char myStr;
        PrintTask2(char myStr){
            this.myStr = myStr;
        }
    @Override
    public void run() {
        long sum = 0;
        for (long i = 0; i < 500_000_000L; i++) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                Thread.currentThread().interrupt();
                return;
            }
            sum += i;
        }
        System.out.printf("%c: Done (Sum: %d) [%s]\n", myStr, sum, Thread.currentThread().getName());
    }
}

public class J046MultipleThread{
    /*
    ExecutorService ser = Executors.newFixedThreadPool(3);
     3 threads are created and started, and they are not reused.
     If more than 3 tasks are submitted, the additional tasks
     will wait in a queue until a thread is available.
     */
    static void main() {
        J046MultipleThread.fixedThreadPool();
        System.out.println("----------------------------------------");
        J046MultipleThread.catchThreadPool();
    }

    static void catchThreadPool() {
        try (ExecutorService ser = Executors.newCachedThreadPool()) {
            // Cached thread pool it creates a new thread only when it is
            // necessary and reuse previously constructed threads when they
            // are available. If no threads are available, it creates new
            // threads. It is suitable for applications that launch many
            // short-lived tasks.
            for(int i=0;i<5;i++){
                PrintTask2 task = new PrintTask2((char)('A'+i));
                ser.execute(task);
            }
            ser.shutdown();
            if (!ser.awaitTermination(2, java.util.concurrent.TimeUnit.SECONDS)) {
                System.out.println("Pool did not terminate");
                ser.shutdownNow();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    static void fixedThreadPool() {
        /*
        ExecutorService ser = Executors.newFixedThreadPool(3);
         3 threads are created and started, and they are reused.
         If more than 3 tasks are submitted, the additional tasks
         will wait in a queue until a thread is available.
     */
        try (ExecutorService ser = Executors.newFixedThreadPool(3)) {
            for(int i=0;i<6;i++){
                PrintTask task = new PrintTask((char)('A'+i));
                ser.execute(task);
            }
            ser.shutdown();
            if (!ser.awaitTermination(2, java.util.concurrent.TimeUnit.SECONDS)) {
                System.out.println("Pool did not terminate");
                ser.shutdownNow();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}