package com.logical;

import java.util.*;
import java.util.stream.Collectors;

public class FindDuplicate {
    public static void main(String[] args) {
//        Integer[] array = {1,2,2,3,3,4,5,5,6,7,8,8,9};
//        List<Integer> list = new ArrayList<>();
//        Collections.addAll(list, array);
//        Set<Integer> set = new HashSet<>();
//        List<Integer> duplicateList = list.stream()
//                .filter(i -> !set.add(i))
//                .collect(Collectors.toList());
//
//        System.out.printf("duplicateList : " + duplicateList);
        Integer arr[] = {1,2,2,3,3,4,5,5,6,7,8,8,9};
        Set<Integer> set = new HashSet<>();
        for (Integer num: arr) {
            if(!set.add(num))
                System.out.println(num);
        }
    }
}

class Bike{
    void run() {
        System.out.println("Running");
    }
}

class Bmw extends Bike {
    void run() {
        System.out.println("Running safely with 120km/hr");
    }
}

class Main{
    public static void main(String args[]){
        Bike b = new Bmw();//upcasting
        b.run();
    }
}

