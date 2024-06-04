package com.polymorphism.compile;

public class Calculate {

    /*
        1. The method name must be the same for all overloaded methods.
        2. The parameter list must be different for each overloaded method.
        3. The return type can be the same or different for the overloaded methods.
    */
    public int add(int a, int b){
        return a + b;
    }

    public int add(int a, int b, int c){
        return a + b + c;
    }

    public double add(double a, double b){
        return a + b;
    }

    public double add(int a, double b){
        return a + b;
    }

    public double add(double a, int b){
        return a + b;
    }

}
