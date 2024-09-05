package com.practice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Example04 {

    public static void main(String[] args) {
         Integer[] arr = new Integer[]{1,4,5,6,2,2,6,2,2,7,2,2,2};
        Integer i = Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
//                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
        System.out.println(i);

    }

}
