package com.example;
public class J017GetterSetter {
    private String color;
    private String model;
    private long price;
    private double fuelLevel;

    public J017GetterSetter(String color, double fuelLevel) {
        this.color = color;
        this.fuelLevel = fuelLevel;
    }

    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }
}
