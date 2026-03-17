package com.inheritance;

import java.util.Objects;

class Person {
    private String name;
    private int age;
    private String id;

    public Person(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Person other)) {
            return false;
        }
        return this.name.equals(other.name) && this.age == other.age && this.id.equals(other.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, age, id);
    }
}

public class J021EqualsHashCode {
    static void main() {
        Person p1 = new Person("John", 25, "123");
        Person p2 = new Person("John", 25, "123");
        IO.println(p1.equals(p2));
    }
}