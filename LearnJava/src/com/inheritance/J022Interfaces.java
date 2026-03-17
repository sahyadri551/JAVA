package com.inheritance;

interface Transport {
    void drive();
    void stop();
    void turnLeft();
    void turnRight();
    void accelerate();
    void brake();
}

abstract class Vechicle implements Transport {
    int numberOfWheels;
    String color;
    String model;
}

class Car extends Vechicle {
    String carNumber;
    int numberOfDoors;
    int numberOfSeats;

    Car() {
        this.numberOfWheels = 4;
        this.color = "Red";
        this.model = "BMW";
        this.carNumber = "ABC123";
        this.numberOfDoors = 4;
        this.numberOfSeats = 5;
    }

    @Override
    public void drive() {
        System.out.println( "Car is driving...");
    }

    @Override
    public void stop() {
        System.out.println( "Car is stopped...");
    }

    @Override
    public void turnLeft() {
        System.out.println( "Car is turning left...");
    }

    @Override
    public void turnRight() {
        System.out.println( "Car is turning right...");
    }

    @Override
    public void accelerate() {
        System.out.println( "Car is accelerating...");
    }

    @Override
    public void brake() {
        System.out.println( "Car is braking...");
    }
}

public class J022Interfaces {
    public static void main(String[] args) {
        Car car = new Car();
        car.drive();
        car.turnLeft();
        car.turnRight();
        car.accelerate();
        car.brake();
        car.stop();
    }
}