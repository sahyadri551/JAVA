package com.polymorphism;

interface Transport {
    void drive();
    void stop();
    void turnLeft();
    void turnRight();
    void accelerate();
    void brake();
}

abstract class Vehicle implements Transport {
    int numberOfWheels;
    String color;
    String model;
}

class Car extends Vehicle {
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

class Truck extends Vehicle {
    String truckNumber;
    int numberOfDoors;
    int numberOfSeats;

    Truck() {
        this.numberOfWheels = 4;
        this.color = "Red";
        this.model = "BMW";
        this.truckNumber = "ABC123";
        this.numberOfDoors = 4;
        this.numberOfSeats = 5;
    }


    @Override
    public void drive() {
        System.out.println( "Truck is driving...");
    }

    @Override
    public void stop() {
        System.out.println( "Truck is stopped...");
    }

    @Override
    public void turnLeft() {
        System.out.println( "Truck is turning left...");
    }

    @Override
    public void turnRight() {
        System.out.println( "Truck is turning right...");
    }

    @Override
    public void accelerate() {
        System.out.println( "Truck is accelerating...");
    }

    @Override
    public void brake() {
        System.out.println( "Truck is braking...");
    }
}

public class J023Overloading {
    static void main(String[] args) {
        Car car = new Car();
        Truck truck = new Truck();

        VehDrive(car);
        VehDrive(truck);

    }
    public static void VehDrive(Transport transport) {
        transport.drive();
    }
}
