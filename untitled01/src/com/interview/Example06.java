package com.interview;


import java.util.List;
import java.util.OptionalInt;

//FIND ALL MISSING POSITIVE NUMBERS IN THE ARRAY IN BTW MIN AND MAX NUMBER
//
//        Input: nums = [3,6,-1,1]
//
//        Output: 2,4,5
//
//        Test Case
//
//        -> Numbers May not be in sequence. numbers may be like [34,67,89,23,67].
//
//        -> All the numbers are present then need to print the next number from the seq of array.
public class Example06 {

    public static void main(String[] args) {
        List<Integer> nums = List.of(3, 6, -1, 1);

        int max = nums.stream().mapToInt(Integer::valueOf).max().getAsInt();

        for(int i = 0 ; i < max; i++){
            if( i > 0 && !nums.contains(i)){
                System.out.println(i);
            }
        }

    }
}

