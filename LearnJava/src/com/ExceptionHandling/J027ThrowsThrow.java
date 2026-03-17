package com.ExceptionHandling;
class Test{
    void test(String name) throws IllegalArgumentException, NullPointerException{
        if(name == null || name.isEmpty()){
            throw new NullPointerException("Name cannot be null or empty");
        }
        boolean valid =  name.trim().length() >= 3 && name.matches("[A-Za-z ]+");
        if(!valid){
            throw new IllegalArgumentException("Name must be at least 3 characters long and contain only letters and spaces");
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