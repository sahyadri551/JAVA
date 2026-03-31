package com.functionalProgramming;

import java.util.List;

public class J050Streams  {
    static void main() {
        List<String> l1 = List.of("Apple", "Banana", "Pear", "Strawberry", "Melon","Date","Orange");
//        l1.stream().forEach(f -> System.out.println(f));
        l1.stream()
            .filter(s -> s.endsWith("e"))
            .forEach(System.out::println);

        List<Integer> l2 = List.of(1, 2, 3, 4, 5);
//        System.out.println(l2.stream().reduce(0, (a, b) -> a + b));
        System.out.println(l2.stream().reduce(0, Integer::sum));

        l2.stream()
            .map( l -> l*l )
            .forEach(System.out::println);
    }
}