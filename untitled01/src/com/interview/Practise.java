package com.interview;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Practise {


    public static void main(String[] args) {
        String str = "In t=32.34seconds 2 of 18 will increase 11x times";

        String[] split = str.split(" ");
        String numString  = "0123456789";

        for(String s : split){
            StringBuilder sb= new StringBuilder();
            for(int i = 0; i < s.length(); i++){
                if(numString.contains(String.valueOf(s.charAt(i)))){
                    sb.append(String.valueOf(s.charAt(i)));
                } else {
                    if(sb.length() > 1){
                        Integer num = Integer.valueOf(sb.toString());
                        if(!sb.toString().endsWith("8")){
                            if (num % 2 == 0){

                            }
                        }
                    }

                }
            }
            sb.append(s);
        }
    }

    public static void main1(String[] args) {
        String[] input1 = {"geeksforgeeks", "geeks", "geek", "geezer"};
        System.out.println(findLongestPrefix(input1));

        Map<String, Integer> map = new HashMap<>();
        map.put("vivek", 100);
        map.put("Rinku", 400);
        map.put("vishal", 600);
        map.put("shankar", 500);

        Stream<Integer> sorted = map.values().stream().sorted(Comparator.reverseOrder());


        Integer secondHighest = map.values().stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();

        System.out.println(secondHighest);

        int[] arr = new int[]{11,12,11,13,14,15,14,16};

        IntStream distinct = Arrays.stream(arr).distinct();
        distinct.forEach(System.out::println);

    }

    public static String findLongestPrefix(String[] str){
        String prefix = str[0];
        for(int i = 1; i < str.length; i++){
            int minLength = Math.min(prefix.length(), str[i].length());
            int j = 0;
            while(j < minLength && prefix.charAt(j) == str[i].charAt(j)){
                j++;
            }
            prefix = prefix.substring(0,j);
        }
        return prefix;
    }




}
