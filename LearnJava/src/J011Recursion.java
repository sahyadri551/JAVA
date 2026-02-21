void main() {
    int result = Integer.parseInt(IO.readln("Enter a number:"));
    long factResult = fact(result);
    if (factResult==0){
        IO.println("Maximum integer size reached");
    } else if (factResult==-1) {
        IO.println("Negative number is not allowed");
    }else
        IO.println("Factorial of %d is %d".formatted(result, factResult));
}
long fact(int n){
    if (n<0) return -1;
    if (n == 0) return 1;
    return n * fact(n - 1);
}