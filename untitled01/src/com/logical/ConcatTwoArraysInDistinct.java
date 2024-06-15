package com.logical;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConcatTwoArraysInDistinct {
    public static void main(String[] args) {
        // Create two arrays
        Integer[] array1 = {1, 5, 3, 2, 4};
        Integer[] array2 = {7, 6, 10, 9, 8};

        // Merge the two arrays, remove duplicates, and sort the result
        Set<Integer> mergedAndSortedArray = Stream.concat(Arrays.stream(array1), Arrays.stream(array2))
                .collect(Collectors.toCollection(TreeSet::new));

        // Print the merged and sorted array
        System.out.println(mergedAndSortedArray);
    }
}
