package com.multithreadding;

public class J042ThreadSleep {
    static void main(){
        try {
            System.out.println("Before sleep: " + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("After sleep: " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted: " + e.getMessage());
        }
    }
}
