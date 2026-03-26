package com.CollectionsLib;

enum Color {
    RED("Stop"), GREEN("Go"), BLUE("Go slowly");

    final private String action;
    Color(String action) {
        this.action = action;
    }
    @Override
    public String toString() {
        return action;
    }
}

enum Grade {
    A, B, C, D, F

}

public class J037Enums {
    static void main() {
        Color c = Color.RED;
        System.out.println(c);
//        System.out.println(c.toString());
        Grade g = Grade.valueOf("A");
        System.out.println(g);
        for(Grade g2 : Grade.values()) {
            System.out.println(g2);
        }
    }
}