package com.logical;

import java.util.Stack;

public class BracketMatchingProblem {

    public static void main(String[] args) {
        System.out.println(isBracketMatching(")([(({}))]"));
    }

    public static Boolean isBracketMatching(String s){
        Stack<Character> stack = new Stack<>(); // Create a new stack
        for(int i = 0; i < s.length(); i++ ){ // iterate whole string by its length
            char ch = s.charAt(i);
            if(isOpening(ch)){ // check character is Opening bracket or not
               stack.push(ch); // isOpening then push it into stack
            } else { // isNotOpening then
               if(stack.isEmpty()){ // check stack is empty or not
                   return false;
               } else if(!isMatching(stack.peek(), ch)){ // check closing bracket with top
                   return false;
               } else {
                   stack.pop();
               }
            }
        }
        return stack.isEmpty();
    }

    public static Boolean isOpening(char c){
        return c == '(' || c == '{' || c == '[';
    }

    public static Boolean isMatching(char a, char b){
        return (a == '(' && b == ')') || (a == '{' && b == '}') || (a == '[' && b == ']');
    }

}
