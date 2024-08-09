package com.interview;




//        Input : [1,2,3,4,5,6]
//        output : pair1 (1,4) (2,3)
//        pair2 (3,4) (1,6)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Example05 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int target = 7;
        List<Integer[]> arrayList = new ArrayList<>();
        Map<Integer, Integer> integerListMap = new HashMap<>();
        for(int num : arr){
            int complement = target - num;
            if(integerListMap.containsKey(complement)){
                arrayList.add(new Integer[]{complement, num});
            }
            integerListMap.put(num, 1);
        }

        arrayList.forEach((val) -> {
            System.out.println(val[0] + " " + val[1]);
        });
    }
}
