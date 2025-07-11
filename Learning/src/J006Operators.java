// File: Operators.java
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;
public class J006Operators {
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
        System.out.println("&& (Logical AND): " + (false && 5/0 == 0)); // Demonstrating short-circuit evaluation
        // The second part (5/0 == 0) will not be evaluated because the first part (false) is already false 
        
        //System.out.println("&& (Logical AND): " + (true && 5/0 == 0)); // This will throw an ArithmeticException
        // Uncommenting the above line will cause an exception, so it's commented out

        //System.out.println("|| (Logical OR): " + (false || 5/0 == 0)); // This will throw an ArithmeticException
        // Uncommenting the above line will cause an exception, so it's commented out

        System.out.println("|| (Logical OR): " + (true || 5/0 == 0)); // Demonstrating short-circuit evaluation
        // The second part (5/0 == 0) will not be evaluated because the first part (true) is already true
        System.out.println("|| (Logical OR): " + (x || y));
        System.out.println("! (Logical NOT): " + (!x));

        /*
         * =======Bitwise Operators=======
         * & (Bitwise AND) - Performs a bitwise AND operation
         * | (Bitwise OR) - Performs a bitwise OR operation
         * ^ (Bitwise XOR) - Performs a bitwise XOR( Exclusive OR ) operation 
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
        System.out.println("~ (Bitwise NOT): " + (~(-e))); // Inverts bits of -e (e.g., 1010 becomes 0101, which is 5 in two's complement) 
        System.out.println("<< (Left shift): " + (e << 1)); // Shifts bits of e to the left (e.g., 0101 becomes 1010, which is 10 in decimal)
        System.out.println(">> (Right shift): " + (e >> 1)); // Shifts bits of e to the right (e.g., 0101 becomes 0010, // which is 2 in decimal)
        System.out.println(">>> (Unsigned right shift): " + (e >>> 1)); // Shifts bits of e to the right, filling with zeros
        // (e.g., 0101 becomes 0010, which is 2 in decimal)

        System.out.println("e in binary: " + Integer.toBinaryString(e)); // Displays e in binary
        System.out.println("-e in binary: " + Integer.toBinaryString(-e)); // Displays -e in binary
        System.out.println("f in binary: " + Integer.toBinaryString(f)); // Displays f in binary
        System.out.println("~ (Bitwise NOT) in binary: " + Integer.toBinaryString(~e)); // Displays the result of ~e in binary

        System.out.println(" binary of -5 to integer "+(byte)0b11111111111111111111111111111011);

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

        /*
         * =======Type Casting=======
         * Type casting is the process of converting a variable from one type to another.
         * There are two types of type casting:
         * 1. Implicit Casting (Widening Conversion) - Automatically done by the compiler when converting a smaller data type to a larger data type.
         * 2. Explicit Casting (Narrowing Conversion) - Manually done by the programmer when converting a larger data type to a smaller data type.
         */
        System.out.println("=======Type Casting=======");
        // Implicit Casting (Widening Conversion)
        int j = 100;
        double d1 = j; // int to double
        System.out.println("Implicit Casting (int to double): " + d1);
        // Explicit Casting (Narrowing Conversion)
        double d2 = 9.78;
        int k = (int) d2; // double to int
        System.out.println("Explicit Casting (double to int): " + k);

        /*
         * =======BigDecimal Arithmetic=======
         * BigDecimal is used for precise decimal arithmetic, especially in financial calculations.
         * It provides control over scale and rounding modes, which is crucial for avoiding precision issues in
         * floating-point arithmetic.
         * BigDecimal is immutable, meaning that operations on BigDecimal objects return new instances rather than
         * modifying the original object.
         * BigDecimal supports various operations like addition, subtraction, multiplication, division, and more.
         * It is particularly useful when dealing with monetary values, where precision is critical.
         * BigDecimal can be created using the BigDecimal(String) constructor or by using the valueOf() method.
         * When performing division, you can specify the scale (number of decimal places) and the rounding mode to handle cases where the result is not exact.
         * Common rounding modes include RoundingMode.HALF_UP, RoundingMode.DOWN, RoundingMode.UP, etc.
         * BigDecimal also supports arithmetic operations like add(), subtract(), multiply(), and divide() with
         * options for scale and rounding mode.
         */
        System.out.println("=======BigDecimal Arithmetic=======");
        BigDecimal bd = BigDecimal.valueOf(20).setScale(2);
        BigDecimal bd2 = BigDecimal.valueOf(3);
        BigDecimal bd3 = bd.divide(bd2, RoundingMode.HALF_UP); // Dividing BigDecimal with scale and rounding mode
        System.out.println("BigDecimal of 20 with scale 2: " + bd3);
        // Note: BigDecimal is used for precise decimal arithmetic, especially in financial calculations.

        /*
         * =======Floating Point Arithmetic=======
         * Floating-point arithmetic can lead to precision issues due to the way numbers are represented in binary.
         * It's important to be cautious when comparing floating-point numbers.
         */
        System.out.println("=======Floating Point Arithmetic=======");
        double d3 = 5.1,d4 = 2.3;
        System.out.println(d3-d4); // Subtracting two doubles
        System.out.println(d3-d4 == 2.8); // Checking if the result is equal to 2.8
        // Note: Comparing floating-point numbers directly can lead to inaccuracies due to precision issues.
        // It's better to use a tolerance value for comparison, especially in financial applications.
        double tolerance = 0.0001; // Define a small tolerance value
        boolean isEqual = Math.abs((d3 - d4) - 2.8) < tolerance; // Check if the difference is within the tolerance
        System.out.println("Is the result equal to 2.8 within tolerance? " + isEqual);
        // This approach ensures that minor floating-point inaccuracies do not affect the comparison result.

        //subtracting two BigDecimal values
        BigDecimal bd4 = BigDecimal.valueOf(5.1).setScale(1);
        BigDecimal bd5 = BigDecimal.valueOf(2.3).setScale(1);
        BigDecimal bd6 = bd4.subtract(bd5);
        System.out.println("Subtracting two BigDecimal values: " + bd6);

        /*
         * Reference Data type comparison
         * When comparing reference data types (objects), the == operator checks if both references point to
         * the same object in memory, while the equals() method checks if the contents of the objects are the same.
         * It's important to use the equals() method for content comparison, especially when dealing with strings or custom objects.
         * The == operator should be used for reference comparison,
         * while the equals() method should be used for value comparison.
         */
        System.out.println("=======Reference Data Type Comparison=======");
        Integer int1 = 129;
        Integer int2 = 129;
        System.out.println("Using == operator: " + (int1 == int2)); // false, because int1 and int2 are different Integer objects in memory
        System.out.println("Using equals() method: " + int1.equals(int2)); // true, because the contents of both Integer objects are the same
        
        // Comparing strings
        String str3 = "Hello";
        String str4 = "Hello";
        System.out.println("Using == operator for strings: " + (str3 == str4)); // true, because both references point to the same string literal in the string pool
        System.out.println("Using equals() method for strings: " + str3.equals(str4)); // true  
        String str5 = new String("Hello");
        System.out.println("Using == operator with new String: " + (str3 == str5)); // false, because str3 and str5 are different objects in memory
        System.out.println("Using equals() method with new String: " + str3.equals(str5)); // true, because the contents of both String objects are the same

        /*
         * =======Integer Caching=======
         * Integer caching is a feature in Java where small integer values (from -128 to 127) are cached and reused to save memory.
         * When you create an Integer object with a value within this range, Java uses the cached instance instead of creating a new object.
         */
        System.out.println("=======Integer Caching=======");
        Integer cachedInt1 = 100; // This will use the cached instance
        Integer cachedInt2 = 100; // This will also use the cached instance
        System.out.println("Using == operator with cached integers: " + (cachedInt1 == cachedInt2)); // true, because both references point to the same cached instance
        Integer uncachedInt1 = 200; // This will create a new Integer object outside the cached range
        Integer uncachedInt2 = 200; // This will also create a new Integer object
        System.out.println("Using == operator with uncached integers: " + (uncachedInt1 == uncachedInt2)); // false, because uncachedInt1 and uncachedInt2
        // are different Integer objects in memory
        System.out.println("Using equals() method with uncached integers: " + uncachedInt1.equals(uncachedInt2)); // true, because the contents of both Integer objects are the same

        // Note: Integer caching in Java only applies to values between -128 and 127,
        // so integers outside this range will not be cached and will create new Integer objects.
        // For example, Integer int1 = 128; Integer int2 = 128;
        // will create two different Integer objects, and the == operator will return false.
        // However, for values between -128 and 127, the == operator will return true
        // because those values are cached by the Integer class.
        // For example, Integer int1 = 100; Integer int2 = 100;
        // will return true because both int1 and int2 point to the same cached Integer object

        // Creating Integer objects using different methods
        System.out.println("=======Other Method Of Creating Integer Objects=======");
        Integer int7 = new Integer(100); //Deprecated constructor, but still valid
        Integer int8 = Integer.valueOf(100); // Preferred way to create Integer objects
        Integer int9 = Integer.parseInt("100"); // Parsing a string to create an Integer
        Integer int10 = Integer.valueOf(100); // This will use the cached instance for values between -128 and 127
        System.out.println("Using new Integer(): " + (int7 == int8)); // false, because int7 is a new Integer object
        System.out.println("Using Integer equals(): " + int7.equals(int8)); // true, because the contents of both Integer objects are the same
        System.out.println("Using Integer.parseInt(): " + (int8 == int9)); // true, because int8 and int9 are both created from the same value and point to the
        // same cached Integer object
        System.out.println("Using Integer.valueOf(): " + (int8 == int10)); // true, because int8 and int10 are both created from the same value and point to the
        // same cached Integer object

        /*
         * Array Comparison
         * When comparing arrays in Java, the == operator checks if both references point to the same array object in memory.
         * When comaring using equals() method, it checks if both references point to the same
         * array object in memory. However, the equals() method for arrays does not compare the
         * contents of the arrays. To compare the contents of two arrays, you should use the
         * java.util.Arrays.equals() method, which checks if the contents of both arrays are the
         * same.
         */
        System.out.println("=======Array Comparison=======");
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        System.out.println("Using == operator for arrays: " + (arr1 == arr2)); // false, because arr1 and arr2 are different array objects in memory
        System.out.println("Using equals() method for arrays: " + arr1.equals(arr2)); // false, because arr1 and arr2 are different array objects
        System.out.println("Using Arrays.equals() method for arrays: " + java.util.Arrays.equals(arr1, arr2)); // true, because the contents of both arrays are the same


    }
}
