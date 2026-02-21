 public class Car{
    private static final String MSG_FUEL_LEVEL = "Fuel level: ";
    static int noOfCarsSold=0;
    int noOfWheels;
    String color;
    float maxSpeed;
    float acceleration;
    float currentSpeed;
    int noOfSeats;
    float maxFuelCapacity;
    float fuelLevel;
    float fuelConsumption;
    boolean isRunning;
    String carNumber;

    Car(int noOfWheels,int noOfSeats,float maxSpeed,float fuelCapacity,float fuelConsumption,String color,String carNumber){
        noOfCarsSold++;
        this.noOfWheels = noOfWheels;
        this.noOfSeats = noOfSeats;
        this.maxSpeed = maxSpeed;
        this.maxFuelCapacity = fuelCapacity;
        this.color = color;
        this.fuelConsumption = fuelConsumption;
        this.carNumber = carNumber;
    }
    Car (){
        this(4,5,250,100,2,"Red","ABC123");
        this.fuelLevel =5;
        IO.println("Car created");
        IO.println(MSG_FUEL_LEVEL + fuelLevel);
    }
    Car start(){
        if (fuelLevel==0){
            IO.println("Please fill the fuel capacity");
        } else if (fuelLevel<2) {
            IO.println("Car is in reserved state, please fill the fuel capacity");
        }else if (isRunning) {
            IO.println("Car is already running");
        } else {
            IO.println("Car started");
            isRunning = true;
            currentSpeed = 10;
        }
        return this;
    }

//    public String toString() {
//    return "Car{" +
//            "color='" + color + '\'' +
//            ", speed=" + currentSpeed +
//            ", fuel=" + fuelLevel +
//            '}';
//    }

     public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("color='").append(color).append('\'');
        sb.append(", noOfWheels=").append(noOfWheels);
        sb.append(", noOfSeats=").append(noOfSeats);
        sb.append(", maxSpeed=").append(maxSpeed);
        sb.append(", acceleration=").append(acceleration);
        sb.append(", carNumber='").append(carNumber).append('\'');
        sb.append(", maxFuelCapacity=").append(maxFuelCapacity);
        sb.append(", speed=").append(currentSpeed);
        sb.append(", fuel=").append(fuelLevel);
        sb.append('}');
        return sb.toString();
    }

    void stop(){
        if (!isRunning) {
            IO.println("Car is already stopped");
        } else {
            IO.println("Car stopped");
            isRunning = false;
            currentSpeed = 0;
        }
    }

    void accelerate(float acceleration){
        if (isRunning) {
            if (currentSpeed + acceleration <= maxSpeed) {
                currentSpeed += acceleration;
                IO.println("Current speed: " + currentSpeed);
                fuelLevel -= fuelConsumption;
                if (fuelLevel <= 0) {
                    stop();
                    IO.println("Out of fuel, car stopped");
                    isRunning = false;
                } else if (fuelLevel< 2) {
                    IO.println("Fuel level is low, please refuel");
                }
            } else {
                IO.println("Car cannot accelerate beyond max speed");
            }
        } else {
            IO.println("Please start the car first");
        }
    }
    void drive(){
        if (isRunning) {
            IO.println("Car is running");
            IO.println("Current speed: " + currentSpeed);
            IO.println(MSG_FUEL_LEVEL + fuelLevel);
            fuelLevel -= fuelConsumption;
            if (fuelLevel <= 0) {
                stop();
                IO.println("Out of fuel, car stopped");
                isRunning = false;
            } else if (fuelLevel< 2) {
                IO.println("Fuel level is low, please refuel");
            }
        } else {
            IO.println("Please start the car first");
        }
    }
    void brake(){
        if (isRunning) {
            currentSpeed -= acceleration;
        }
    }

    void fillFuel(float fuel){
        if (fuelLevel==maxFuelCapacity) {
            IO.println("Fuel is full");
        } else if (fuelLevel + fuel > maxFuelCapacity) {
            IO.println("Cannot fill fuel beyond capacity");
            IO.println(MSG_FUEL_LEVEL + fuelLevel);
        } else {
            fuelLevel += fuel;
            IO.println( MSG_FUEL_LEVEL + fuelLevel);
        }
    }
}