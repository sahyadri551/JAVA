package com.CollectionsLib;

public class J038GenericsDiamond {
    static void main() {
        MyClass<String> c1 = new MyClass<>("Smt");
        System.out.println(c1.getValue());
         MyClass<Integer> c2 = new MyClass<>(123);
        System.out.println(c2.getValue());
        c2.setValue(456);
        System.out.println(c2.getValue());
    }
    static class MyClass<T> {
        private T value;
        MyClass(T value) {
            this.value = value;
        }
        public T getValue() {
            return value;
        }
        public void setValue(T value) {
            this.value = value;
        }
    }
}