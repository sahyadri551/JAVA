package com.OptionalProgramming;

import java.util.Optional;

public class J051OptionalProgramming  {
    static void main() {
        Optional<String> optionalOf = Optional.of("Hello");
        Optional<String> optionalEmp = Optional.empty();
        Optional<String> nullPointer = Optional.ofNullable(null);

        if (optionalOf.isPresent()) {
            System.out.println(optionalOf.get());
        }
        if (optionalEmp.isPresent()) {
            System.out.println(optionalEmp.get());
        }
        nullPointer.ifPresent(System.out::println);
        System.out.println(nullPointer.orElse("Hello"));

    }
}