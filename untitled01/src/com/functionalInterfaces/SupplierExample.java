package com.functionalInterfaces;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<Integer> s1 = () -> 10;
        System.out.println(s1.get());


        Random random = new Random();
        Supplier<Integer> s2 = () -> random.nextInt(1000000);
        System.out.println(s2.get());
        System.out.println(s2.get());
    }
}
