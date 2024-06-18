package com.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class example01 {

    public static void main(String[] args) {
        List<Card> cardList = new ArrayList<>();
        String heart = "HEART";
        String dimond = "DIMOND";
        String club = "CLUD";
        String spade = "SPADE";

        int num = new Random(0).nextInt();
        System.out.println(num);

//        for (int i = 0; i < 13; i++){
//            String value = Integer.valueOf(i).toString();
//            if(i == 11) value = "JOKER";
//            if(i == 12) value = "QUEEN";
//            if(i == 13) value = "JOKER";
//
//            cardList.add(new Card(heart, ));
//            cardList.add(new Card(dimond, Integer.valueOf(i).toString()));
//            cardList.add(new Card(club, Integer.valueOf(i).toString()));
//            cardList.add(new Card(spade, Integer.valueOf(i).toString()));
//        }
    }
}
class Card {
    private String face;
    private String value;

    Card(String face, String value){
        this.face = face;
        this.value = value;
    }


}