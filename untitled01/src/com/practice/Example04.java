package com.practice;

import com.streamapi.Example01;
import com.streamapi.Student;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Example04 {

    public static void main(String[] args) {
        // Find the repeated one
         Integer[] arr = new Integer[]{1,4,5,6,2,2,6,2,2,7,2,2,2};
        Integer repeated = Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).get();

        //System.out.println(repeated);

        List<Student> studentList = Example01.STUDENT_LIST;

        Map.Entry<String, Long> longEntry = studentList.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue()).get();
        //System.out.println(longEntry);

        String str = "SARAH";

        String s = str.chars()
                .mapToObj(c -> (char) c)
                .distinct()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining());
//        System.out.println(s);

        List<Integer> list = List.of(1,3,4,6,7,5,9);
        Integer max = list.stream()
                .mapToInt(Integer::intValue)
                .max().getAsInt();
        int sum = list.stream().filter(num -> num != max).mapToInt(Integer::intValue).sum();
        System.out.println(max);
        System.out.println(sum);

    }

}
