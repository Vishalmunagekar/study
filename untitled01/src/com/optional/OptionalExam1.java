package com.optional;

import java.util.Optional;

public class OptionalExam1 {

    public static void main(String[] args) {
        String s1 = new String("");
        //Optional<String> os1 = Optional.of(null); //NullPointerException
        Optional<String> os2 = Optional.of("Vishal Munagekar");
        Optional<String> os3 = Optional.ofNullable(null); // this will work
        if(os3.isPresent()){
            os3.get();
        } else {
            System.out.println("Value Not present!");
        }



    }

}
