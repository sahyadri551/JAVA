void main(){
    int a = Integer.parseInt(IO.readln("Enter a number:"));
    int b = Integer.parseInt(IO.readln("Enter another number:"));
    try {
        int c = a / b;
        IO.println(c);
    } catch (Exception e) {
        IO.println("An error occurred: " + e.getMessage());
    } finally {
        IO.println("This will always execute");
    }
}