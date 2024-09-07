package com.streamapi;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example01 {
    public static List<Student> STUDENT_LIST = Arrays.asList(
            new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
            new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
            new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
            new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
            new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
            new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
            new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
            new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
            new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
            new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));
    public static void main(String[] args) {



        //  1- Find list of students whose first name starts with alphabet A
        Stream<Student> studentStream = STUDENT_LIST.stream().filter((student) -> student.getFirstName().startsWith("A"));
        //studentStream.forEach(System.out::println);

        //  2- Group The Student By Department Names
        Map<String, List<Student>> mapOfStudentDept = STUDENT_LIST.stream().collect(Collectors.groupingBy(Student::getDepartmantName));
        //System.out.println(mapOfStudentDept);

        // 3- Find the total count of student using stream
        long count = STUDENT_LIST.stream().count();
        //System.out.println(count);

        // 4- Find the max age of student
        OptionalInt maxAge = STUDENT_LIST.stream().mapToInt((student) -> student.getAge()).max();
        //System.out.println(maxAge.getAsInt());

        // 5- Find all departments names
        List<String> deptList = STUDENT_LIST.stream().map((student) -> student.getDepartmantName()).distinct().collect(Collectors.toList());
        //System.out.println(deptList);

        // 6- Find the count of student in each department
        Map<String, Long> collect = STUDENT_LIST.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()));
        //System.out.println(collect);

        // 7- Find the list of students whose age is less than 30
        List<Student> studentList = STUDENT_LIST.stream().filter(student -> student.getAge() < 30).collect(Collectors.toList());
        //System.out.println(studentList);

        // 8- Find the list of students whose rank is in between 50 and 100
        List<Student> rankInBtwn50To100 = STUDENT_LIST.stream().filter(student -> student.getRank() > 50 && student.getRank() < 100).collect(Collectors.toList());
        //System.out.println(rankInBtwn50To100);

        //9- Find the average age of male and female students
        Map<String, Double> mapAvgAge = STUDENT_LIST.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
        //System.out.println(mapAvgAge);

        // 10- Find the department who is having maximum number of students
        Map<String, Long> mapDeptCount = STUDENT_LIST.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()));
        //System.out.println(mapDeptCount);
        Map.Entry<String, Long> entry = mapDeptCount.entrySet().stream().max(Map.Entry.comparingByValue()).get();
        //System.out.println(entry);

        // 11- Find the Students who stays in Mumbai and sort them by their names
        List<Student> mumbaiStudents = STUDENT_LIST.stream()
                .filter(student -> student.getCity().equalsIgnoreCase("Mumbai"))
                .sorted(Comparator.comparing(Student::getFirstName))
                .collect(Collectors.toList());
        //System.out.println(mumbaiStudents);

        // 12- Find the average rank in all departments
        Map<String, Double> deptStudentRanks = STUDENT_LIST.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.averagingInt(Student::getRank)));
        //System.out.println(deptStudentRanks);

        // 13- Find the highest rank in each department
        Map<String, Optional<Student>> highestRankDept = STUDENT_LIST.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.maxBy(Comparator.comparing(Student::getRank))));
        //System.out.println(highestRankDept);

        // 14- Find the list of students and sort them by their rank
        List<Student> sortedByRank = STUDENT_LIST.stream().sorted(Comparator.comparing(Student::getRank)).collect(Collectors.toList());
        //System.out.println(sortedByRank);

        // 14.2- Find the list of students name and sort them by their rank
        List<String> stringList = STUDENT_LIST.stream().sorted(Comparator.comparing(Student::getRank)).map(Student::getFirstName).collect(Collectors.toList());
        //System.out.println(stringList);

        // 15- Find the student who has second rank
        Student student = STUDENT_LIST.stream().sorted(Comparator.comparing(Student::getRank)).skip(1).findFirst().get();
        //System.out.println(student);

        // 16- Merge two Employee ArrayList and sort by age
        List<Student> newList = Stream.concat(STUDENT_LIST.stream(), STUDENT_LIST.stream()).sorted(Comparator.comparing(Student::getAge)).collect(Collectors.toList());

        // 17- Find even numbers from ArrayList and find the sum of all numbers
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);

        int sum = numbers.stream().filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue).sum();
        //System.out.println(sum);

        // 18- Sort student by name and rank
        List<Student> sortedByNameAndByRank = STUDENT_LIST.stream().sorted(Comparator.comparing(Student::getFirstName).thenComparing(Student::getRank)).collect(Collectors.toList());

        // 19- Sort Students based on gender and age is above 30 using
        STUDENT_LIST.stream().filter(s -> s.getAge() > 30)
                .sorted(Comparator.comparing(Student::getGender))
                .collect(Collectors.toList());


        Integer reduce = numbers.stream().reduce(0, (a, b) -> a + b);
        //System.out.println(reduce);

        List<List<Integer>> nestedLists = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4, 5),
                Arrays.asList(6)
        );

        List<Integer> integerList = nestedLists.stream().flatMap(List::stream).collect(Collectors.toList());
        //System.out.println(integerList);


        Integer max = numbers.stream().max(Integer::compare).get();
        Integer min = numbers.stream().min(Integer::compare).get();
        //System.out.println(max);
        //System.out.println(min);

        Integer findFirst = numbers.stream().filter(num -> num % 2 == 0).findFirst().get();

        Integer findAny = numbers.stream().filter(num -> num % 2 == 0).findAny().get();
        //System.out.println(findFirst); // 2
        //System.out.println(findAny); // 2


        String str = "VISHAL MUNAGEKAR"; //sort this and make it distinct

        String collect1 = str.chars()
                .distinct()
                .sorted()
                .filter(c -> c != ' ')
                .mapToObj(value -> (char) value)
                .map(String::valueOf).collect(Collectors.joining());

        //System.out.println(collect1);
    }


}
