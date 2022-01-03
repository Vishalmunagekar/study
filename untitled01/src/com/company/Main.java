package com.company;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        Collection<String> collection = getCollection();
        System.out.println(collection.toString());
        HashSet<String> hashset = new HashSet<>();
        hashset.addAll(collection);
        System.out.println(hashset.toString());
    }
    public static Collection<String> getCollection(){
        Collection<String> codeWords = new ArrayList<>();
        codeWords.add("one"); codeWords.add("two"); codeWords.add("three"); codeWords.add("four");
        codeWords.add("one");
        codeWords.add("two");
        return codeWords;
    }
}
