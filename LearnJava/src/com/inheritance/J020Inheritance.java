package com.inheritance;

import java.util.EnumSet;
import java.util.Objects;

enum PowerSource {
    HUMAN_PEDAL("Powered by human pedaling"),
    COMBUSTION("Powered by a combustion engine"),
    ELECTRIC("Powered by electricity"),
    HYBRID("Powered by a hybrid system");

    private final String description;

    PowerSource(String description) {
        this.description = description;
    }

    public String description() {
        return description;
    }

    public boolean hasMotor() {
        return this != HUMAN_PEDAL;
    }

    public boolean isElectric() {
        return this == ELECTRIC || this == HYBRID;
    }
}

enum EngineType {
    NONE,
    V_TWIN,
    INLINE_FOUR,
    ELECTRIC_MOTOR,
    CVT_COMBUSTION
}

sealed abstract class TwoWheeler extends Vehicle permits Bicycle, Motorcycle, Scooter {

    private final PowerSource powerSource;

    protected TwoWheeler(String color, String model, long price, PowerSource powerSource) {
        super(2, color, model, price);
        this.powerSource = Objects.requireNonNull(powerSource);
    }

    public PowerSource getPowerSource() {
        return powerSource;
    }

    public boolean hasMotor() {
        return powerSource.hasMotor();
    }

    public boolean isElectric() {
        return powerSource.isElectric();
    }

    @Override
    public String toString() {
        return super.toString() +
                " [" + powerSource.description() + "]";
    }
}

final class Bicycle extends TwoWheeler {

    private Bicycle(String color, String model, long price,
                    PowerSource powerSource) {
        super(color, model, price, powerSource);
    }

    public static Bicycle regular(String color, String model, long price) {
        return new Bicycle(color, model, price, PowerSource.HUMAN_PEDAL);
    }

    public static Bicycle electric(String color, String model, long price) {
        return new Bicycle(color, model, price, PowerSource.ELECTRIC);
    }
}

final class Motorcycle extends TwoWheeler {

    private final EngineType engineType;

    private Motorcycle(String color, String model, long price, PowerSource powerSource, EngineType engineType) {

        super(color, model, price, powerSource);

        if (!EnumSet.of(PowerSource.COMBUSTION,
                        PowerSource.ELECTRIC,
                        PowerSource.HYBRID).contains(powerSource)) {
            throw new IllegalArgumentException("Motorcycle must have a motor");
        }

        if (engineType == null || engineType == EngineType.NONE) {
            throw new IllegalArgumentException("Valid engine type required");
        }

        this.engineType = engineType;
    }

    public static Motorcycle combustion(String color, String model, long price, EngineType engineType) {

        if (!EnumSet.of(EngineType.V_TWIN,
                        EngineType.INLINE_FOUR,
                        EngineType.CVT_COMBUSTION).contains(engineType)) {
            throw new IllegalArgumentException("Invalid combustion engine type");
        }

        return new Motorcycle(color, model, price,
                PowerSource.COMBUSTION, engineType);
    }

    public static Motorcycle electric(String color, String model, long price) {

        return new Motorcycle(color, model, price,
                PowerSource.ELECTRIC, EngineType.ELECTRIC_MOTOR);
    }

    public EngineType getEngineType() {
        return engineType;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", engineType=" + engineType;
    }
}

final class Scooter extends TwoWheeler {

    private final EngineType engineType;
    private final int storageCapacityLiters;

    private Scooter(String color, String model, long price, PowerSource powerSource, EngineType engineType, int storage) {

        super(color, model, price, powerSource);

        if (storage <= 0) {
            throw new IllegalArgumentException("Storage must be positive");
        }

        this.engineType = engineType;
        this.storageCapacityLiters = storage;
    }

    public static Scooter cityScooter(String color, String model, long price, int storage) {
        return new Scooter(color, model, price,
                PowerSource.COMBUSTION,
                EngineType.CVT_COMBUSTION,
                storage);
    }

    public static Scooter electricScooter(String color, String model, long price, int storage) {
        return new Scooter(color, model, price, PowerSource.ELECTRIC, EngineType.ELECTRIC_MOTOR, storage);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", engineType=" + engineType +
                ", storage=" + storageCapacityLiters + "L";
    }
}

public class J020Inheritance {
    public static void main(String[] args) {

        Bicycle bike = Bicycle.regular("Red", "Trek", 500);
        Bicycle ebike = Bicycle.electric("Blue", "RadPower", 1500);

        Motorcycle harley = Motorcycle.combustion("Black", "Harley", 15000, EngineType.V_TWIN);

        Scooter vespa = Scooter.cityScooter("Yellow", "Vespa GTS", 5000, 15);

        System.out.println(bike);
        System.out.println(ebike);
        System.out.println(harley);
        System.out.println(vespa);
    }
}