void main(){

    // Mathematical constants and functions------------------------------------------------
    IO.println(Math.PI);
    IO.println(Math.E);
    IO.println(Math.sqrt(25));
    IO.println(Math.pow(2, 3));// output 8
    IO.println(Math.round(3.7)); // output 4
    IO.println(Math.ceil(3.7));// output 4
    IO.println(Math.floor(3.7));// output 3
    IO.println(Math.abs(-3)); // output 3
    IO.println(Math.max(3, 4)); // output 4
    IO.println(Math.min(3, 4)); // output 3
    IO.println(Math.rint(3.7));// output 4
    IO.println(Math.exp(1));// output 2.718281828459045 => e^1 is the value of e

    // Trigonometric functions-------------------------------------------------------
    IO.println(Math.sin(Math.PI/2));// output 0
    IO.println(Math.cos(Math.PI/2));// output 1
    IO.println(Math.tan(Math.PI/4));// output 1
    IO.println(Math.toDegrees(Math.PI));// output 180
    IO.println(Math.toRadians(180));// 3.141592653589793
    IO.println(Math.asin(0.5));// output 0.5235987755982988
    IO.println(Math.acos(0.5));// output 1.0471975511965976
    IO.println(Math.atan(1));// output 0.7853981633974483
    IO.println(Math.atan2(1, 1));// output 0.7853981633974483 =>  atan(1/sqrt(2))

    // logarithmic functions--------------------------------------------------------------
    IO.println(Math.log(Math.E));// output 1
    IO.println(Math.log10(100));// output 2
    IO.println(Math.log1p(1));// output 0.6931471805599453 => log(1+1)
    IO.println(Math.expm1(1));// output 0.6931471805599453 => exp(1)-1

    // other functions-------------------------------------------------------------------
    IO.println(Math.cbrt(27));// output 3 => cube root of 27
    IO.println(Math.IEEEremainder(10, 3));// output 1 => remainder of 10/3
    IO.println(Math.ulp(1.0)); // output 0.0000000000000002 => smallest positive number such that 1+ulp(1) != 1
    IO.println(Math.signum(-1.0));// output -1 => it returns -1 if x is negative, 0 if x is 0 and 1 if x is positive

    // Random numbers -------------------------------------------------------------------
    IO.println(Math.random());
    // integer random number between 0 and 10
    IO.println((int)(Math.random() * 11));
    // floating point random number between 0 and 10
    IO.println(Math.random() * 10);
    // integer random number between 1 and 10
    IO.println((int)(Math.random() * 10) + 1);
}