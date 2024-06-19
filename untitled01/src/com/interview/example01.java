package com.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class example01 {

    public static void main(String[] args) {
        List<Card> cardList = new ArrayList<>();
        String heart = "HEART";
        String diamond = "DIAMOND";
        String club = "CLUB";
        String spade = "SPADE";

        for (int i = 1; i <= 13; i++){
            String value = Integer.valueOf(i).toString();
            if(i == 1) value = "A";
            if(i == 11) value = "JOKER";
            if(i == 12) value = "QUEEN";
            if(i == 13) value = "KING";
            cardList.add(new Card(heart, value));
            cardList.add(new Card(diamond, value));
            cardList.add(new Card(club, value));
            cardList.add(new Card(spade, value));
        }
        cardList.stream().forEach(System.out::println);
        Collections.shuffle(cardList);
        System.out.println("-------------------- shuffled --------------------");
        cardList.stream().forEach(System.out::println);
    }
}
class Card {
    private String face;
    private String value;

    Card(String face, String value){
        this.face = face;
        this.value = value;
    }
    @Override
    public String toString() {
        return "Card{" + "face='" + face + '\'' + ", value='" + value + '\'' + '}';
    }
}