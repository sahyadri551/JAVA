public class J007MathClassOp {
    public static void main(String[] args) {
        // Math class operations
        System.out.println("========== Math Constants ===========");
        System.out.println("Math.PI: " + Math.PI);
        System.out.println("Math.E: " + Math.E);
        
        // Absolute value
        System.out.println("========== Absolute Value ===========");
        System.out.println("Absolute value of -10: " + Math.abs(-10));
        
        // Power
        System.out.println("========== Power ===========");
        System.out.println("2 raised to the power of 3: " + Math.pow(2, 3));
        
        // Square root
        System.out.println("========== Square Root ===========");
        System.out.println("Square root of 16: " + Math.sqrt(16));

        // Fun with NaN (Not a Number) and Infinity
        System.out.println("========== NaN and Infinity ===========");
        System.out.println("Square root of 16: " + Math.sqrt(-16)); // This will return NaN
        System.out.println("Division by zero: " + (0.0 / 0.0)); // This will return NaN
        System.out.println(5/0.0); // This will return Infinity


        // Trigonometric functions
        System.out.println("========== Trigonometric Functions ===========");
        System.out.println("Sine of 30 degrees: " + Math.sin(Math.toRadians(30)));
        System.out.println("Cosine of 60 degrees: " + Math.cos(Math.toRadians(60)));
        System.out.println("Tangent of 45 degrees: " + Math.tan(Math.toRadians(45)));
        System.out.println("Arc sine of 0.5: " + Math.asin(0.5));
        System.out.println("Arc cosine of 0.5: " + Math.acos(0.5));
        System.out.println("Arc tangent of 1: " + Math.atan(1));

        // Logarithmic functions
        System.out.println("========== Logarithmic Functions ===========");
        System.out.println("Natural logarithm of 10: " + Math.log(10));
        System.out.println("Base 10 logarithm of 100: " + Math.log10(100));
        System.out.println("Base 2 logarithm of 8: " + Math.log(8) / Math.log(2));
        System.out.println("Logarithm of 0: " + Math.log(0)); // This will return -Infinity
        System.out.println("Logarithm of negative number: " + Math.log(-10)); // This will return NaN
        System.out.println("Logarithm of 1: " + Math.log(1)); // This will return 0.0

        // Exponential function
        System.out.println("========== Exponential Function ===========");
        System.out.println("Exponential of 1: " + Math.exp(1));// This will return e^1
        System.out.println("Exponential of 2: " + Math.exp(2)); // This will return e^2
        System.out.println("Exponential of -1: " + Math.exp(-1)); // This will return e^-1
        System.out.println("Exponential of 0: " + Math.exp(0));// This will return e^0, which is 1.0

        // Rounding functions
        System.out.println("========== Rounding Functions ===========");
        System.out.println("Round 5.7: " + Math.round(5.7));// This will return 6
        System.out.println("Round 5.4: " + Math.round(5.4));// This will return 5
        System.out.println("Ceiling of 5.1: " + Math.ceil(5.1));// This will return 6
        System.out.println("Ceiling of 5.1: " + Math.ceil(-5.1));// This will return -5
        System.out.println("Floor of 5.9: " + Math.floor(5.9));// This will return 5
        System.out.println("Floor of -5.9: " + Math.floor(-5.9));// This will return -6 
        System.out.println("Rint of 5.5: " + Math.rint(5.5));// This will return 6.0
        System.out.println("Rint of 5.4: " + Math.rint(5.4));// This will return 5.0

        

        // Maximum and minimum
        System.out.println("========== Maximum and Minimum ===========");
        System.out.println("Maximum of 5 and 10: " + Math.max(5, 10));
        System.out.println("Minimum of 5 and 10: " + Math.min(5, 10));
        
        // Random number
        System.out.println("========== Random Number ===========");
        System.out.println("Random number between 0.0 and 1.0: " + Math.random());
        // Random number between 1 and 10
        int randomNum = (int)(Math.random() * 10) + 1;
        System.out.println("Random number between 1 and 10: " + randomNum);
    }
    
}
