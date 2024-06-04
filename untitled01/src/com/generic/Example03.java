package com.generic;

public class Example03 {

    /*
    * Integer extends Number
    * Double extends Number
    * */


    public static void main(String[] args) {
        Foo<Integer> f1 = new Foo<Integer>();
        f1.x = 10;
        f1.x = 20;

        Foo<? extends Number > f2 = new Foo<Integer>();
     // f2.x = 10; doesn't compile

        Foo<? super Number> f3 = new Foo<Number>();
        f3.x = 10;
    }

    static Foo<Integer> m1(){
        return null;
    }
}
