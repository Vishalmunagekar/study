package com.logical;

import java.util.Arrays;
import java.util.List;

public class CountNumbersInStringsArrays {

    public static void main(String[] args) {
        List<String> list = List.of("qw1er5ty8ui", "f7gh5jk2l", "3po6iu4y", "8xc5vbn1m0");

        String digits = "0123456789";
        var res = list.stream()
                      .flatMap(s -> Arrays.stream(s.split("")))
                .filter(s -> digits.contains(s))
                .count();
        System.out.println(res);
    }
}
