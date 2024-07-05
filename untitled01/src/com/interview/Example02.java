package com.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Example02 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        List<Integer> integerList = list.stream().distinct().collect(Collectors.toList());
        Set<Integer> integerSet = list.stream().collect(Collectors.toSet());
        method(null);
    }

    public static void method(Object s){
        System.out.println("Integer");
    }
    public static void method(String s){
        System.out.println("String");
    }
}
