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


class Bike{
    public static int c =0;

    public Bike() {
    }

    public Bike(int x){
        c = x;
    }

    void method(){
        c =20;
    }
    void run() {
        System.out.println("Running");
    }
}

//class Bmw extends Bike{
//    void run() {
//        System.out.println("Running safely with 120km/hr");
//    }
//}

class Main{
    public static void main(String args[]){
//        Bike b = new Bmw();//upcasting
//        b.run();
        Bike b = new Bike();
        System.out.println(Bike.c);
    }
}