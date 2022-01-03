package com.functionalInterfaces;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateInterface {
    public static void main(String[] args) {
        //Predicate<T> always return boolean
        Predicate<Integer> p1 = n -> n % 2 == 0;

        boolean even1 = p1.test(10);
        System.out.println(even1);
        boolean even2 = p1.test(5);
        System.out.println(even2);

        //BiPredicate<T, U>
        BiPredicate<String, Integer> bp = (s , i) -> s.length() == i;

        boolean bool1 = bp.test("vishal", 10);
        System.out.println(bool1); //false
        boolean bool2 = bp.test("vishalmunagekar", 15);
        System.out.println(bool2); //true
    }
}
