package com.multithreadding;
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
public class J039ThreadPriority {
    static void main() {
        Thread t1 = new Thread(new PrintTask('@'), "Thread-1");
        Thread t2 = new Thread(new PrintTask('#'), "Thread-2");
        Thread t3 = new Thread(new PrintTask('$'), "Thread-3");
        Thread t4 = new Thread(new PrintTask('%'), "Thread-4");

        System.out.println("t4 State before start: " + t4.getState());
        t4.start();

        try {
            t4.join(200,300); // waits for the specified time for the thread to finish
        } catch (InterruptedException e) {
            System.out.println( e.getMessage());
        } finally {
            System.out.println("Thread 4 is done.");
            System.out.println(t4.getPriority());
            System.out.println(t4.isAlive());
            System.out.println(t4.isInterrupted()); // returns true if the thread is interrupted
            System.out.println(t4.getState()); // returns the state of the thread
            System.out.println(t4.getName()); // returns the name of the thread
            System.out.println(t4.threadId()); // returns the unique identifier of the thread
            System.out.println(t4.getThreadGroup()); // returns the thread group of the thread
            //t4.interrupt(); // interrupts the thread
            System.out.println("--------------------------------------------------");
        }

        t1.setPriority(Thread.MAX_PRIORITY); // sets the priority of the thread to 10
        t3.setPriority(Thread.MIN_PRIORITY); // sets the priority of the thread to 1

        long startTime = System.currentTimeMillis();

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println( e.getMessage());
        }
        finally {
            System.out.println("All threads are done.");
            System.out.println(t1.getPriority());
            System.out.println(t2.getPriority());
            System.out.println(t3.getPriority());
            long endTime = System.currentTimeMillis();
            System.out.println("Time taken: " + (endTime - startTime) + " ms");
        }
    }
}