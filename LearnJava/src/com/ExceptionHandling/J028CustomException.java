package com.ExceptionHandling;

class TemperatureException extends RuntimeException {
    private final double temperature;

    public TemperatureException(double temperature) {
        super("Temperature " + temperature + " is out of range (must be between -50 and 50)");
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }
}
public class J028CustomException {
    public static void main(String[] args) {
        try {
            throw new TemperatureException(100);
        } catch (TemperatureException e) {
            System.out.println(e.getMessage());
        }

    }
}