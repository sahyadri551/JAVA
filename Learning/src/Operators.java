// File: Operators.java
import java.util.Scanner;
public class Operators {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        /*
         * =======Arithmetic Operators=======
         * ===Unary Operators===
         * + (Unary plus) - Indicates positive value (not necessary)
         * - (Unary minus) - Negates the value
         * ++ (Increment) - Increases the value by 1
         * -- (Decrement) - Decreases the value by 1
         * ===Binary Operators===
         * + (Addition) - Adds two values
         * - (Subtraction) - Subtracts the second value from the first
         * * (Multiplication) - Multiplies two values
         * / (Division) - Divides the first value by the second
         * % (Modulus) - Returns the remainder of the division of the first value by the second
         */

         System.out.println("=======Arithmetic Operators=======");
         System.out.println("===Unary Operators===");
        int a = 5;
        System.out.println("+ (Unary plus): " + (+a));
        System.out.println("- (Unary minus): " + (-a));
        System.out.println("++ (Increment): " + (++a));// prefix increment
        a++; // Incrementing a again to demonstrate the effect of postfix increment
        System.out.println("++ (Increment again): " + a);
        a--; // Decrementing a again to demonstrate the effect of postfix decrement
        System.out.println("-- (Decrement): " + a);
        System.out.println("-- (Decrement): " + (--a));// prefix decrement
        System.out.println("===Binary Operators===");
        int b = 11;
        System.out.println("+ (Addition): " + (a + b));
        System.out.println("- (Subtraction): " + (a - b));
        System.out.println("* (Multiplication): " + (a * b));
        System.out.println("/ (Division): " + (b / a)); // Note: Division of integers results in an integer quotient
        // If you want a floating-point result, at least one operand should be a double or float
        System.out.println("/ (Division with float): " + ((float)b / a));
        System.out.println("% (Modulus): " + (a % b));
        System.out.println("% (Modulus with negative number): " + (-a % b)); // Modulus with a negative number
        System.out.println("% (Modulus with negative number): " + (a % -b)); // Modulus with a negative divisor
        System.out.println("% (Modulus with both negative): " + (-a % -b)); // Modulus with both negative numbers
        //concatenation Property of + operator
        String str1 = "Hello";
        String str2 = "World";
        System.out.println("Concatenation using + operator: " + (str1 + " " + str2));
        System.out.println("Concatenation using + operator with numbers: " + (str1 + " " + 123 + " " + str2 + " " + 456));
        System.out.println("Concatenation using + operator with numbers: " + (123 + " " + str1 + " " + 456 + " " + str2));

        /*
         * =======Relational Operators=======
         * == (Equal to) - Checks if two values are equal
         * != (Not equal to) - Checks if two values are not equal
         * > (Greater than) - Checks if the left value is greater than the right value
         * < (Less than) - Checks if the left value is less than the right value
         * >= (Greater than or equal to) - Checks if the left value is greater than or equal to the right value
         * <= (Less than or equal to) - Checks if the left value is less than or equal to the right value
         * instanceof - Checks if an object is an instance of a specific class
         */
        System.out.println("=======Relational Operators=======");
        int c,d; 
        System.out.println("Enter two integers for relational operations:");
        Scanner scanner = new Scanner(System.in);
        c = scanner.nextInt();
        d = scanner.nextInt();
        scanner.close();
        System.out.println("== (Equal to): " + (c == d));
        System.out.println("!= (Not equal to): " + (c != d));
        System.out.println("> (Greater than): " + (c > d));
        System.out.println("< (Less than): " + (c < d));
        System.out.println(">= (Greater than or equal to): " + (c >= d));
        System.out.println("<= (Less than or equal to): " + (c <= d));
        // Note: instanceof is used with objects, not primitive types like int
        // Example usage of instanceof
        String str = "Hello";
        System.out.println("instanceof: " + (str instanceof String)); // true, since str is an instance of String
        System.out.println("instanceof: " + (str instanceof Object)); // true, since String is a subclass of Object

        /*
         * =======Logical Operators=======
         * && (Logical AND) - Returns true if both operands are true
         * || (Logical OR) - Returns true if at least one operand is true
         * ! (Logical NOT) - Reverses the logical state of its operand
         */
        System.out.println("=======Logical Operators=======");
        boolean x = true, y = false;
        System.out.println("&& (Logical AND): " + (x && y));
        System.out.println("|| (Logical OR): " + (x || y));
        System.out.println("! (Logical NOT): " + (!x));

        /*
         * =======Bitwise Operators=======
         * & (Bitwise AND) - Performs a bitwise AND operation
         * | (Bitwise OR) - Performs a bitwise OR operation
         * ^ (Bitwise XOR) - Performs a bitwise XOR operation
         * ~ (Bitwise NOT) - Inverts the bits of the operand
         * << (Left shift) - Shifts bits to the left, filling with zeros
         * >> (Right shift) - Shifts bits to the right, preserving the sign bit
         * >>> (Unsigned right shift) - Shifts bits to the right, filling with zeros
         */
        System.out.println("=======Bitwise Operators=======");
        int e = 5, f = 3; // Binary: e = 0101, f = 0011
        System.out.println("& (Bitwise AND): " + (e & f)); // Result: 0001 (1 in decimal)
        System.out.println("| (Bitwise OR): " + (e | f)); // Result: 0111 (7 in decimal)
        System.out.println("^ (Bitwise XOR): " + (e ^ f)); // Result: 0110 (6 in decimal)
        System.out.println("~ (Bitwise NOT): " + (~e)); // Inverts bits of e (e.g., 0101 becomes 1010, which is -6 in two's complement)
        System.out.println("<< (Left shift): " + (e << 1)); // Shifts bits of e to the left (e.g., 0101 becomes 1010, which is 10 in decimal)
        System.out.println(">> (Right shift): " + (e >> 1)); // Shifts bits of e to the right (e.g., 0101 becomes 0010, // which is 2 in decimal)
        System.out.println(">>> (Unsigned right shift): " + (e >>> 1)); // Shifts bits of e to the right, filling with zeros
        // (e.g., 0101 becomes 0010, which is 2 in decimal)

        /*
         * =======Assignment Operators=======
         * = (Simple assignment) - Assigns the right operand to the left operand
         * += (Add and assign) - Adds the right operand to the left operand and assigns the result to the left operand
         * -= (Subtract and assign) - Subtracts the right operand from the left operand and assigns the result to the left operand
         * *= (Multiply and assign) - Multiplies the left operand by the right operand and assigns the result to the left operand
         * /= (Divide and assign) - Divides the left operand by the right operand and assigns the result to the left operand
         * %= (Modulus and assign) - Takes modulus using two operands and assigns the result to the left operand
         */
        System.out.println("=======Assignment Operators=======");
        int g = 10;
        System.out.println("= (Simple assignment): " + (g = 20)); // Assigns 20 to g
        System.out.println("+= (Add and assign): " + (g += 5)); // Adds 5 to g (20 + 5 = 25)
        System.out.println("-= (Subtract and assign): " + (g -= 10)); // Subtracts 10 from g (25 - 10 = 15)
        System.out.println("*= (Multiply and assign): " + (g *= 2)); // Multiplies g by 2 (15 * 2 = 30)
        System.out.println("/= (Divide and assign): " + (g /= 3)); // Divides g by 3 (30 / 3 = 10)
        System.out.println("/= (Divide and assign): " + (g /= 4.0)); // Divides g by 4.0 (30 / 4.0 = 7.5)
        System.out.println("%= (Modulus and assign): " + (g %= 3)); // Takes modulus of g by 3 (10 % 3 = 1)

        /*
         * =======Ternary Operator=======
         * ? : (Ternary operator) - A shorthand for if-else statements
         * Syntax: condition ? valueIfTrue : valueIfFalse
         */
        System.out.println("=======Ternary Operator=======");
        int h = 5, i = 10;
        int max = (h > i) ? h : i; // If h is greater than i, max is h; otherwise, max is i
        System.out.println("Ternary Operator: The maximum of " + h + " and " + i + " is " + " " + max);
    }
}
