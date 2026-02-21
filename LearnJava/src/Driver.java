public class Driver{
    public static void main(String[] args){
        Car c1 = new Car(4,2,300,100,2,"Red","ABC456");
        c1.fillFuel(40);
        c1.start().drive();// method chaining
        c1.accelerate(20);
        c1.drive();
        c1.accelerate(30);
        c1.drive();
        c1.fillFuel(10);
        c1.brake();
        c1.stop();
        Car c2 = new Car();
        IO.println(c2.start());

    }
}