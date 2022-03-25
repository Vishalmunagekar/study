package com.thread.synchronize.problem;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Integer> bucket = new ArrayList<>();

    public static void main(String[] args) {
        Producer p1 = new Producer("p1");
        Producer p2 = new Producer("p2");
        Consumer c1 = new Consumer("c1");
        Consumer c2 = new Consumer("c2");

        p1.start();
        c1.start();
        p2.start();
        c2.start();

        System.out.println(Thread.currentThread().getName() + " Ends here!!");

    }

}
/*

c1 took out the value 44 from the bucket
Exception in thread "c2" java.lang.IndexOutOfBoundsException: Index: 0, Size: 1
    at java.util.ArrayList.rangeCheck(ArrayList.java:659)
    at java.util.ArrayList.get(ArrayList.java:435)
    at com.thread.synchronize.problem.Consumer.run(Consumer.java:13)
Exception in thread "c1" java.lang.NullPointerException
    at com.thread.synchronize.problem.Consumer.run(Consumer.java:13)
c1 took out the value 644 from the bucket
c1 took out the value 528 from the bucket

*/