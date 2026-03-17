package com.WrapperClassses;

public class J031WrapperNumber {
    static void main() {
        Integer i = Integer.valueOf("1000");
        System.out.println("Integer value: " + i);
        i = Integer.parseInt("200");
        System.out.println(i.toString());
        System.out.println(i.intValue());
        System.out.println(i.byteValue());
        System.out.println(i.shortValue());
        System.out.println(i.longValue());
        System.out.println(i.floatValue());
        System.out.println(i.doubleValue());
        System.out.println(i.equals(200));
        System.out.println(i.compareTo(200));
        System.out.println("Integer value: " + i);
    }
}