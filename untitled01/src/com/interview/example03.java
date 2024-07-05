package com.interview;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class example03 {

    public static void main(String[] args) {
        String str = "SARAH";
//        To sort a string and make it distinct using the Stream API in Java,
//        you can follow these steps:
//        1. Convert the string to a stream of characters.
//        2. Sort the stream.
//        3. Remove duplicates.
//        4. Collect the result back into a string.
        String result = str.chars()  // Stream of int representing the characters
                .distinct()  // Remove duplicates
                .sorted()  // Sort the stream
                .mapToObj(c -> (char) c)  // Convert int back to char
                .map(String::valueOf)  // Convert char to String
                .collect(Collectors.joining());  // Join the strings together
        System.out.println(result);
// ===============================================================================
        List<Integer> list = List.of(1,3,4,6,7,5,9);
// Find the maximum value in the list
        OptionalInt maxOptional = list.stream()
                .mapToInt(Integer::intValue)
                .max();

        if (maxOptional.isPresent()) {
            int max = maxOptional.getAsInt();

            // Sum the values excluding the maximum value
            int sum = list.stream()
                    .filter(n -> n != max)
                    .mapToInt(Integer::intValue)
                    .sum();

            System.out.println("Sum excluding the max value: " + sum);
        } else {
            System.out.println("List is empty");
        }
    }
}