package com.practice;

import com.streamapi.Example01;
import com.streamapi.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example05 {
    public static void main(String[] args) {
        Map<String, List<Student>> map = Example01.STUDENT_LIST.stream().collect(Collectors.groupingBy(Student::getGender));
//        System.out.println(map);

        List<Integer> collect = Example01.STUDENT_LIST.stream().map((student -> student.getRank())).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
//        System.out.println(collect);

        List<Student> students = Example01.STUDENT_LIST.stream().sorted(Comparator.comparing(Student::getRank).reversed()).skip(1).collect(Collectors.toList());
        System.out.println(students);



    }
}