package com.polymorphism;

class Human{
    public  int age;
    public  String name;
    public  String gender;

    Human(int age, String name, String gender){
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    void eat(){
        System.out.println("Human is Eating");
    }
    void sleep(){
        System.out.println("Human is Sleeping");
    }
    void walk(){
        System.out.println("Human is Walking");
    }
}
class Student extends Human{
    public  int rollNumber;

    Student(int age, String name, String gender, int rollNumber){
        super(age, name, gender);
        this.rollNumber = rollNumber;
    }

    void study(){
        System.out.println( super.name + " is Studying");
    }
    void play(){
        System.out.println(super.name+" is Playing");
    }
    void eat(){
        System.out.println(super.name+" is Eating");
    }
    void sleep(){
        System.out.println(super.name+" is Sleeping");
    }
    void walk(){
        System.out.println(super.name+" is Walking");
    }
}
public class J025Overriding {
    public static void main(String[] args) {
        Student s1 = new Student(20, "Rahul", "Male", 101);
        s1.eat();
        s1.sleep();
        s1.walk();
        s1.study();
        s1.play();

        Human h1 = new Human(20, "Rahul", "Male");
        h1.eat();
        h1.sleep();
        h1.walk();
    }
}
