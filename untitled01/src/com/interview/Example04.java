package com.interview;

//Input: strs = ["eat","tea","tan","ate","nat","bat"]

//        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]


import java.util.*;

public class Example04 {

    public static void main(String[] args) {
        String[] arr = new String[]{"eat","tea","tan","ate","nat","bat"};
        Map<String, List<String>> stringListMap = new HashMap<>();

        for(String word : arr){
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);
            if(!stringListMap.containsKey(sortedWord)){
                stringListMap.put(sortedWord, new ArrayList<>());
            }
            stringListMap.get(sortedWord).add(word);
        }
        System.out.println(stringListMap.values());
    }

}
