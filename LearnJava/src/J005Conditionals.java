void main(){
    // if statement
    Scanner scan = new Scanner(System.in);

    IO.print("Enter a number:");
    int a = scan.nextInt();
    if(a > 0){
        IO.println("a is positive");
    }

    // if else statement
    if(a > 0){
        IO.println("a is positive");
    }else{
        IO.println("a is negative");
    }

    // nested if statement
    if(a > 0){
        if(a % 2 == 0){
            IO.println("a is even");
        }else{
            IO.println("a is odd");
        }
    }else {
        IO.println("a is zero or negative");
    }

    // else if statement
    if(a > 0){
        IO.println("a is positive");
    }else if(a == 0){
        IO.println("a is zero");
    } else{
        IO.println("a is negative");
    }

    // switch statement -> old
//    switch(a){
//        case 0:
//            IO.println("a is zero");
//            break;
//        case 1:
//            IO.println("a is one");
//            break;
//        default:
//            IO.println("a is neither zero nor one");
//    }

    // switch statement -> new
    IO.print("Enter a number between 1 and 12:");
    int month = scan.nextInt();
    switch(month){
        case 1 -> IO.println("January");
        case 2 -> IO.println("February");
        case 3 -> IO.println("March");
        case 4 -> IO.println("April");
        case 5 -> IO.println("May");
        case 6 -> IO.println("June");
        case 7 -> IO.println("July");
        case 8 -> IO.println("August");
        case 9 -> IO.println("September");
        case 10 -> IO.println("October");
        case 11 -> IO.println("November");
        case 12 -> IO.println("December");
        default -> IO.println("Invalid month");
    }
    IO.print("Enter a day of the week:");
    int day = scan.nextInt();
    String type = switch (day) {
    case 1, 2, 3, 4, 5 -> "Weekday";
    case 6, 7 -> "Weekend";
    default -> "Invalid";
    };
    IO.println(type);
    scan.close();
}