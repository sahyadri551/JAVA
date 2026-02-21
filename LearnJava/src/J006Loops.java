void main(){
    // while loop
    int i = 0;
    while(i < 10){
        IO.println(i);
        i++;
    }

    // for loop
    for(int j = 0; j < 10; j++){
        IO.println(j);
    }

    // break and continue statements
    for(int k = 0; k < 10; k++){
        if(k == 5){
            break; // exit the loop when k is 5
        }
        if(k % 2 == 0){
            continue; // skip the rest of the loop when k is even
        }
        IO.println(k); // print odd numbers less than 5
    }

    // do while loop
    int l = 0;
    do{
        IO.println(l);
        l++;
    }while(l < 10);

    // nested loops
    for(int m = 0; m < 3; m++){
        for(int n = 0; n < 3; n++){
            IO.println("m: " + m + ", n: " + n);
        }
    }

    // array loop
    int[] a = {1, 2, 3, 4, 5};
    for(int o : a){
        IO.println(o);
    }
    
}