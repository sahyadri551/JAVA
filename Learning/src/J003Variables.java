public class J003Variables {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        int sum = a + b;
        System.out.println("The sum is: " + sum);
        long largeNumber = 1_234_567_890_123_000_000L  ;
        System.out.println("A large number: " + largeNumber);
        double pi = 3.14159;
        short r = 15;
        System.out.println("Area of circle: " + pi * r * r);
        boolean isJavaFun = true;
        System.out.println("Is Java fun? " + isJavaFun);
        double temperature = 36.6;
        System.out.println("Current temperature: " + temperature + "°C");
        char grade = 'A';
        // Variable conversion example
        System.out.println("Grade: " + grade);
        char i = 1000;
        System.out.println("Character representation of 1000: " + i);

        int i2 = grade;
        System.out.println("Integer value of grade: " + i2);

        temperature = largeNumber;
        System.out.println("Updated temperature: " + temperature + "°C");

        int j = (int) pi;
        System.out.println("Integer value of pi: " + j);
    }
}