package com.generic;

public class Example01 {

    public static void main(String[] args) {

        // this code also works coz java 01 doesn't have the generics
        Foo f = new Foo();
        f.x = 5;
        f.x = "VISHAL";

        // ----------------
        Foo<String> f1 = new Foo<String>();
        f1.x = "VISHAL";

        Foo<Integer> f2 = new Foo<>();
        f2.x = 10;
    }

}
