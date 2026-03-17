package com.polymorphism;

class J024Overloading2 {
    static void main() {
        J024Overloading2 o = new J024Overloading2();
        o.sum(1, 2);
        o.sum(1, 2, 3);
        o.sum(1.2, 2.3);
        o.sum(1, 2.3);
        o.sum(1.2, 2);
        o.sum(1,2,3,44,5,6,7);
        o.sum(4.0,5.9,4.9,6.40);
    }
    // vararg
    public void sum( int... args) {
        int sum=0;
        for (int i : args) {
            sum+=i;
        }
        System.out.println(sum);
    }
    public void sum(double... args) {
        double sum=0;
        for (double i : args) {
            sum+=i;
        }
        System.out.println(sum);
    }
    public void  sum(int a, int b) {
        System.out.println(a + b);
    }
    public void  sum(int a, int b, int c) {
        System.out.println(a + b + c);
    }
    public void  sum(double a, double b) {
        System.out.println(a + b);
    }
    public void  sum(int b, double a) {
        System.out.println(a + b);
    }
    public void  sum(double a, int b) {
        System.out.println(a + b);
    }
}
