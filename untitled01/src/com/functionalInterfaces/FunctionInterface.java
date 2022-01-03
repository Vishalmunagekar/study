package com.functionalInterfaces;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionInterface {
    public static void main(String[] args) {
        //Function< T , R >
        Function<String, Integer> f1 = s -> s.length();
        Integer length = f1.apply("Vishal_Munagekar");
        System.out.println(length); //16

        //BiFunction<T, U, R>
        BiFunction<String, String, Integer> bf = (s1, s2) -> s1.length() + s2.length();
        Integer length2 = bf.apply("Vishal", "Munagekar");
        System.out.println(length2); //15
    }
}
