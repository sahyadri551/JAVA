package com.ExceptionHandling;
class Test{
    void test(String name) throws IllegalArgumentException{
        if (name == null || name.trim().isEmpty()) {
        throw new IllegalArgumentException("Name cannot be null or empty");
    }
    if (name.trim().length() < 3 || !name.matches("[A-Za-z ]+")) {
        throw new IllegalArgumentException("Name must be at least 3 letters.");
    }
    System.out.println("Hello, " + name);
    }
    public static void main(String[] args) {
        Test test = new Test();
        try{
            test.test(null);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        try{
            test.test(" ");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        try{
            test.test("Ab   ");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        try{
            test.test("Abcde");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        try{
            test.test("Abc123");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}