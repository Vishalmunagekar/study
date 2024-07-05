package com.interview;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Array = [3, 5, -4, 8, 11, 1, -1, 6, 2, 5, 7]
//        Target Sum = 10
//        Result = [-1,11], [8,2], [5, 5], [3, 7]


public class PairWithTargetSum {

    public static void main(String[] args) {
        int[] array = {3, 5, -4, 8, 11, 1, -1, 6, 2, 5, 7};
        int targetSum = 10;

        List<int[]> resultList = new ArrayList<>(); // create a list with array of int
        Map<Integer, Integer> integerMap = new HashMap<>(); // create a map with key int and val int

        for(int num : array){ //iterate array
            int complement = targetSum - num; // calculate complement by using targetSum and num ( targetSum - num)
            if(integerMap.containsKey(complement)){ // check that complement is present in that map or not
                resultList.add(new int[]{complement, num}); // if yes then u got the set now add that to list of int
            }
            integerMap.put(num, 1);
        }

        resultList.forEach((arr) ->{
            System.out.println("[" + arr[0] + " " + arr[1] + "]");
        });
    }
}


