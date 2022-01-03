package com.functionalInterfaces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        //Consumer
        //BiConsumer
        //Supplier
        //Function
        //BiFunction
        //Predicate
        //BiPredicate
        //UniaryOperator
        //BinaryOperator

        //
        Consumer<String> c1 = s -> System.out.println(s);
        c1.accept("We are using Consumer<T> interface...");

        BiConsumer<Integer, String> c2 = (a , b) -> System.out.println(a + " " + b);
        c2.accept(10, " <- Ten");

        List<Integer> list = new ArrayList<>();
        list.add(10); list.add(20); list.add(30); list.add(40);

        Consumer<Integer> c3 = n -> System.out.println(n);
        list.forEach(c3);

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");

        BiConsumer<Integer, String> bc = (number, value) -> System.out.println(number + " " + value);
        map.forEach(bc);
    }
}
