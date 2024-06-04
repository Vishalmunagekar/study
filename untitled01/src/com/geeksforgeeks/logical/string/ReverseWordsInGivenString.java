package com.geeksforgeeks.logical.string;

public class ReverseWordsInGivenString {
    public static void main(String[] args) {
        String str = "geeks quiz practice code";
        System.out.println(reverseWordsInGivenString(str));
    }

    private static String reverseWordsInGivenString(String str) {
        StringBuilder builder = new StringBuilder();
        int endWord = str.length();
        for(int i = str.length()- 1; i >= 0; i--){
            if(str.charAt(i) == ' '){
                builder.append(str, i +1, endWord);
                builder.append(' ');
                endWord = i;
            }
        }
        return builder.append(str, 0, endWord).toString();
    }
}

