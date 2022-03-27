package com.logical;

import java.util.Stack;

public class BracketMatchingWithIncludingString {


    public static void main(String[] args) {
        System.out.println(isBracketMatchingWithIncludingString("(5[()]){}152"));
    }

    public static Boolean isBracketMatchingWithIncludingString(String str){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(isBracket(ch)){
                if(isOpening(ch)){
                    stack.push(ch);
                } else {
                    if(stack.isEmpty()){
                        return false;
                    } else if (!isMatching(stack.peek(), ch)){
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static Boolean isBracket(char c){
        return c == '(' || c == '{' || c == '[' || c == ')' || c == '}' || c == ']';
    }

    public static Boolean isOpening(char c){
        return c == '(' || c == '{' || c == '[';
    }

    public static Boolean isMatching(char a, char b){
        return (a == '(' && b == ')') || (a == '{' && b == '}') || (a == '[' && b == ']');
    }

}
