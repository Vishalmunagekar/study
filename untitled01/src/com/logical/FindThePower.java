package com.logical;

public class FindThePower {
    public static void main(String[] args) {
        System.out.println(power(3, 3));
    }

    public static int power(int b, int p) {
        int power = 1;
        for(int i = 1; i <= p; i++) {
            power = power * b;
        }
        return power;
    }
}
