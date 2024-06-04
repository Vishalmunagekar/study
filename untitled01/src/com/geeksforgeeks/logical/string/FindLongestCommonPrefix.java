package com.geeksforgeeks.logical.string;

public class FindLongestCommonPrefix {

    public static void main(String[] args) {
        String[] input1 = {"geeksforgeeks", "geeks", "geek", "geezer"};
        String[] input2 = {"apple", "ape", "april"};
        System.out.println(findLongestCommonPrefix(input1));
        System.out.println(findLongestCommonPrefix(input2));
    }

    private static String findLongestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            prefix = commonPrefix(prefix, strs[i]);
            if(prefix.isEmpty())
                break;
        }
        return prefix;
    }

    private static String commonPrefix(String str1, String str2){
        int minLength = Math.min(str1.length(), str2.length());
        int i = 0;
        while (i < minLength && str1.charAt(i) == str2.charAt(i)){
            i++;
        }
        return str1.substring(0,i);
    }
}
