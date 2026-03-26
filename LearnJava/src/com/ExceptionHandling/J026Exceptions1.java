void main() {
    try {
        int a = Integer.parseInt(IO.readln("Enter a number:"));
        int b = Integer.parseInt(IO.readln("Enter another number:"));
        int c = a / b;
        IO.println(c);
    } catch (NumberFormatException e) {
        IO.println("Error: You did not enter a valid integer.");
    } catch (ArithmeticException e) {
        IO.println("Error: Cannot divide by zero.");
    } finally {
        IO.println("Execution complete.");
    }
}