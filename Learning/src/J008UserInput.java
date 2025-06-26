import java.util.Scanner;
public class J008UserInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        System.out.println("Hello, " + name + "! You are " + age + " years old.");

        System.out.println("Enter your first name: ");
        String firstName = scanner.next();
        System.out.println("Enter your last name: ");
        String lastName = scanner.next();
        System.out.println("Hello, " + firstName + " " + lastName + "! You are " + age + " years old.");

        System.out.println("Enter your height in meters: ");
        double height = scanner.nextDouble();
        System.out.println("Your height is " + height + " meters.");

        // boolean input examples
        System.out.print("Enter a boolean value (true/false): ");
        boolean isStudent = scanner.nextBoolean();
        System.out.println("Is student: " + isStudent);

        // byte input example
        System.out.print("Enter a byte value: ");
        byte byteValue = scanner.nextByte();
        System.out.println("You entered byte value: " + byteValue);

        /*
         * Note: The Scanner class can throw exceptions if the input is not of the expected type.
         * Other Methods can be used to read different types of input:
         * - nextInt() for integers
         * - nextDouble() for floating-point numbers
         * - nextBoolean() for boolean values
         * - nextLine() for reading a full line of text
         * - next() for reading a single word
         * - nextByte() for reading byte values
         * - nextShort() for reading short values
         * - nextLong() for reading long values
         * - nextFloat() for reading float values
         * - nextBigInteger() for reading large integers
         * - nextBigDecimal() for reading large decimal numbers
         * 
         */

        scanner.close();
    }
}
