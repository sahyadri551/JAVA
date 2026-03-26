package com.CollectionsLib;
import java.util.HashSet;

public class J035HashSet {
    static void main() {
        HashSet<String> s = new HashSet<>();
        s.add("Apple");
        s.add("Banana");
        s.add("Orange");
        s.add("Mango");
        s.add("Pineapple");
        System.out.println(s);
        s.add("Apple");
        System.out.println(s);
        System.out.println(s.size());
        System.out.println(s.isEmpty());
        System.out.println(s.contains("Apple"));
        System.out.println(s.remove("Apple"));
        System.out.println(s);
        System.out.println(s.toArray());
        System.out.println(s.toString());
        HashSet<String> s2 = new HashSet<>();
        s2.add("Apple");
        s2.add("Banana");
        s2.add("Orange");
        s2.add("Mango");
        s2.add("Pineapple");
        System.out.println(s2.equals(s));
        System.out.println(s2.containsAll(s));
        System.out.println(s2.addAll(s));
        System.out.println(s2);
        System.out.println(s2.retainAll(s));
        System.out.println(s.stream().distinct().count());
        System.out.println(s.stream().sorted().count());
        s.forEach(System.out::println);
        s2.removeIf(e -> e.equals("Apple"));
        System.out.println(s2);
        System.out.println(s.stream().filter(e -> e.equals("Apple")).count());
        System.out.println(s.stream().max(String::compareTo).orElse("No elements"));
        System.out.println(s.stream().min(String::compareTo).orElse("No elements"));
        System.out.println(s.stream().reduce((a, b) -> a + b)); // it will return a string
        System.out.println(s.stream().map(String::toUpperCase).toList()); // it will return a list of strings
        System.out.println(s.stream().map(String::toUpperCase).collect(java.util.stream.Collectors.toList()));// it will return a list of strings
        System.out.println(String.join("", s));// System.out.println(s.stream().collect(java.util.stream.Collectors.joining()));
        s2.clear();
    }
}