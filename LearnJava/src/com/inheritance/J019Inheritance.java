package com.inheritance;

sealed abstract class Vehicle permits TwoWheeler {

    private final int wheels;
    private final String model;
    private String color;
    private long price;

    protected Vehicle(int wheels, String color, String model, long price) {
        if (wheels <= 1) throw new IllegalArgumentException("Wheels must be >= 2");
        if (color == null || color.isBlank()) throw new IllegalArgumentException("Color required");
        if (model == null || model.isBlank()) throw new IllegalArgumentException("Model required");
        if (price <= 0) throw new IllegalArgumentException("Price must be positive");

        this.wheels = wheels;
        this.color = color;
        this.model = model;
        this.price = price;
    }

    public int getWheels() {
        return wheels;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public long getPrice() {
        return price;
    }

    public void repaint(String newColor) {
        if (newColor == null || newColor.isBlank()) {
            throw new IllegalArgumentException("Invalid color");
        }
        this.color = newColor;
    }

    public void updatePrice(long newPrice) {
        if (newPrice <= 0) {
            throw new IllegalArgumentException("Invalid price");
        }
        this.price = newPrice;
    }

    @Override
    public String toString() {
        return "%s{model='%s', color='%s', price=%d}"
                .formatted(getClass().getSimpleName(), model, color, price);
    }
}