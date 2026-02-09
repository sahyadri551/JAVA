void main(){
    printTable(5);
    printTable(7);
    IO.println(sum(3, 4));
    printArray(1, 2, 3, 4, 5);
    r.run();
    r2.run();
    IO.println(add.apply(3, 4));
}
// function with no return
void printTable(int n){
    for(int i = 1; i <= 10; i++){
        IO.println(n + " * " + i + " = " + n * i);
    }
}
// function with return
int sum(int a, int b){
    return a + b;
}

// varargs
void printArray(int... a){
    for(int i : a){
        IO.println(i);
    }
}

// lambda expression
Runnable r = () -> IO.println("Hello World!");

// anonymous class
Runnable r2 = new Runnable(){
    public void run(){
        IO.println("Hello World!");
    }
};
// lambda expression with parameters
BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
BiFunction<Integer, Integer, Integer> add2 = Integer::sum;
