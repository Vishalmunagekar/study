package com.generic;

public class Example02 {

    /*
    * Integer extends Number
    * Double extends Number
    * */


    public static void main(String[] args) {
        Foo<Integer> f1; // Only works with precise type. Only Integer
        Foo<?> f2; // Any object wildcard
        Foo<? extends Number> f3;
        Foo<? super Number> f4;
        Foo<Number> f5;

        f1 = new Foo<Integer>();
     // f1 = new Foo<Number>(); // not compile

        f2 = new Foo<Object>();
        f2 = new Foo<Integer>();
        f2 = new Foo<Double>();
        f2 = new Foo<Number>();

        f3 = new Foo<Number>();
        f3 = new Foo<Integer>();
        f3 = new Foo<Double>();
     // f3 = new Foo<String>(); // not compile

        f4 = new Foo<Number>();
        f4 = new Foo<Object>();
     // f4 = new Foo<Integer>(); // not compile

        f5 = new Foo<Number>();
     // f5 = new Foo<Integer>(); // not compile
     // f5 = new Foo<Object>(); // not compile
    }

    static Foo<Integer> m1(){
        return null;
    }
}
