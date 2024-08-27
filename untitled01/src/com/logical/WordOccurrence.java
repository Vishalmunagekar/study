package com.logical;

import java.util.HashMap;
import java.util.Map;

public class WordOccurrence {
    public static void main(String[] args) {
        String str = "mango is a mango";

        // Split the string into words
        String[] words = str.split(" ");

        // Create a HashMap to store the word count
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Loop through each word in the array
        for (String word : words) {
            // If the word is already in the map, increment its count
            if (wordCountMap.containsKey(word)) {
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            } else {
                // Otherwise, add the word to the map with a count of 1
                wordCountMap.put(word, 1);
            }
        }

        // Print the word occurrences
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

