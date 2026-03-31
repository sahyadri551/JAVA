package com.multithreadding.ExecuterService;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

class PrintTask implements Runnable {
    private final char myStr;
        PrintTask(char myStr){
            this.myStr = myStr;
        }
    @Override
    public void run() {
        long sum = 0;
        for (long i = 0; i < 500_000_000L; i++) {
            sum += i;
        }
        System.out.printf("%c: Done (Sum: %d) [%s]\n", myStr, sum, Thread.currentThread().getName());
    }
}

public class J046SingleThread {
    static void main() {
        try (ExecutorService ser = Executors.newSingleThreadExecutor();) {
            PrintTask task1 = new PrintTask('#');
            PrintTask task2 = new PrintTask('!');
            PrintTask task3 = new PrintTask('@');
            ser.execute(task1);
            ser.execute(task2);
            ser.execute(task3);
            ser.shutdown();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
