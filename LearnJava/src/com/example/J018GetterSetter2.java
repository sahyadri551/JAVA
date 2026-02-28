package com.example;
public class J018GetterSetter2 {
    static void main() {
        J017GetterSetter gs = new J017GetterSetter("Red", 200, "ABC456", 100000);
        IO.println(gs.getColor());
        IO.println(gs.getModel());
    }
}
