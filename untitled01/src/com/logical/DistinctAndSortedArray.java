package com.logical;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DistinctAndSortedArray {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 5, 9, 3, 7, 4, 6, 8, 2, 1, 6, 8);
        list.stream()
                .distinct()
                .sorted() // ascending sorting
                .forEach(System.out::println);
        System.out.println("******************====******************");
        Comparator<Integer> c = Collections.reverseOrder(); // comparator we can use externally
        list.stream()
                .distinct()
                .sorted(c)
                .forEach(System.out::println);



    }
}
