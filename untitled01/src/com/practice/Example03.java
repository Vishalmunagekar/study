package com.practice;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

//Find the no of occurance of each character of String and sort the result keywise
//        and get third one element
//// input is  mumbai
//        Sort output:
//        a=1
//        b=1
//        i=1
//        m=2
//        u=1
//        Element output : i=1
public class Example03 {

    public static void main(String[] args) {
        String str = "mumbai";
        Map<Character, Long> map = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
        Optional<Map.Entry<Character, Long>> maxMap = map.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue));
        Optional<Long> aLong = maxMap.map(Map.Entry::getValue);
        System.out.println(aLong);
    }
}
