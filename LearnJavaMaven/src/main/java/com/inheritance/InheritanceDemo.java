package com.inheritance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public String description() { return description; }
    public boolean hasMotor() { return this != HUMAN_PEDAL; }
    public boolean isElectric() { return this == ELECTRIC || this == HYBRID; }
}

enum EngineType {
    NONE, V_TWIN, INLINE_FOUR, ELECTRIC_MOTOR, CVT_COMBUSTION
}

sealed abstract class TwoWheeler extends Vehicle permits Bicycle, Motorcycle, Scooter {
    private final PowerSource powerSource;

    protected TwoWheeler(String color, String model, long price, PowerSource powerSource) {
        super(2, color, model, price);
        this.powerSource = Objects.requireNonNull(powerSource);
    }

    public PowerSource getPowerSource() { return powerSource; }
    public boolean hasMotor() { return powerSource.hasMotor(); }
    public boolean isElectric() { return powerSource.isElectric(); }

    @Override
    public String toString() {
        return super.toString() + " [" + powerSource.description() + "]";
    }
}

final class Bicycle extends TwoWheeler {
    private Bicycle(String color, String model, long price, PowerSource powerSource) {
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
        if (!EnumSet.of(PowerSource.COMBUSTION, PowerSource.ELECTRIC, PowerSource.HYBRID).contains(powerSource)) {
            throw new IllegalArgumentException("Motorcycle must have a motor");
        }
        if (engineType == null || engineType == EngineType.NONE) {
            throw new IllegalArgumentException("Valid engine type required");
        }
        this.engineType = engineType;
    }

    public static Motorcycle combustion(String color, String model, long price, EngineType engineType) {
        if (!EnumSet.of(EngineType.V_TWIN, EngineType.INLINE_FOUR, EngineType.CVT_COMBUSTION).contains(engineType)) {
            throw new IllegalArgumentException("Invalid combustion engine type");
        }
        return new Motorcycle(color, model, price, PowerSource.COMBUSTION, engineType);
    }

    public static Motorcycle electric(String color, String model, long price) {
        return new Motorcycle(color, model, price, PowerSource.ELECTRIC, EngineType.ELECTRIC_MOTOR);
    }

    public EngineType getEngineType() { return engineType; }

    @Override
    public String toString() {
        return super.toString() + ", engineType=" + engineType;
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
        return new Scooter(color, model, price, PowerSource.COMBUSTION, EngineType.CVT_COMBUSTION, storage);
    }

    public static Scooter electricScooter(String color, String model, long price, int storage) {
        return new Scooter(color, model, price, PowerSource.ELECTRIC, EngineType.ELECTRIC_MOTOR, storage);
    }

    @Override
    public String toString() {
        return super.toString() + ", engineType=" + engineType + ", storage=" + storageCapacityLiters + "L";
    }
}

public class InheritanceDemo {
    private static final Logger logger = LoggerFactory.getLogger(InheritanceDemo.class);
    static void main() {
        var bike = Bicycle.regular("Red", "Giant Escape", 5000L);
        var eBike = Bicycle.electric("Black", "Specialized Turbo", 25000L);

        var harley = Motorcycle.combustion("Black", "Harley-Davidson", 200000L, EngineType.V_TWIN);
        var zero = Motorcycle.electric("Silver", "Zero SR/F", 180000L);

        var hondaScooter = Scooter.cityScooter("Blue", "Honda Active", 80000L, 20);
        var vespaE = Scooter.electricScooter("White", "Vespa Electric", 120000L, 25);

        // Log everything
        logger.info("=== VEHICLES ===");
        logger.info("{}", bike);
        logger.info("{}", eBike);
        logger.info("{}", harley);
        logger.info("{}", zero);
        logger.info("{}", hondaScooter);
        logger.info("{}", vespaE);

        // Test mutators
        bike.repaint("Green");
        logger.info("{}", bike.isElectric());
        logger.info("{}", bike.getPowerSource());
        logger.info("{}", bike.hasMotor());
        logger.info("{}", harley.getEngineType());
        logger.info("Repainted bike: {}", bike);
    }
}
