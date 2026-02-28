package in.LearnJava;
public class Car {
    public String color;
    public String model;
    private long price;
    private double fuelLevel;

    public Car(long price, double fuelLevel, String color, String model) {
        this.price = price;
        this.fuelLevel = fuelLevel;
        this.color = color;
        this.model = model;
    }
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("color='").append(color).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append(", price=").append(price);
        sb.append(", fuelLevel=").append(fuelLevel);
        sb.append('}');
        return sb.toString();
    }
}