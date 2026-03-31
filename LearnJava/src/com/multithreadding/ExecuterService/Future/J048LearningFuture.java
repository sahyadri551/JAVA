package com.multithreadding.ExecuterService.Future;

import java.util.concurrent.*;

class FetchName implements Callable<String> {
    private final String name;

    FetchName(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception{
        System.out.println("Fetching name " + name);
        Thread.sleep(2000,1000);
        return name+" is called";
    }
}

public class J048LearningFuture {
    static void main(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        FetchName task1 = new FetchName("A");
        FetchName task2 = new FetchName("B");
        FetchName task3 = new FetchName("C");
        FetchName task4 = new FetchName("D");
        Future<String> future1 = executorService.submit(task1);
        Future<String> future2 = executorService.submit(task2);
        Future<String> future3 = executorService.submit(task3);
        Future<String> future4 = executorService.submit(task4);

        try {
            System.out.println(future1.get());
            System.out.println(future2.get());
            System.out.println(future3.get());
            System.out.println(future4.get());
            future1.cancel(true);
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e.getMessage());
        } finally {
            executorService.shutdown();
        }
    }
}
