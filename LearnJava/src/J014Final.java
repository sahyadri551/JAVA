void main(){
    final int a = 10;
     // a = 20; //-> gives error: Cannot assign a value to final variable a
    IO.println(a);
    /*
     * Final variables cannot be changed after they are initialized.
     * Final methods cannot be overridden.
     * Final classes cannot be extended.
     * Final parameters cannot be overridden.
     * Conventions:
     * all final variables are written in uppercase letters with underscores separating words.
     * final variables are initialized at the time of declaration or in the constructor.
     */
}