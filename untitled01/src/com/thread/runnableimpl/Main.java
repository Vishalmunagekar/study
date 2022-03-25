package com.thread.runnableimpl;

public class Main {

    public static void main(String[] args) {
        Runnable r1 = new OddNumberRunnable();
        Thread t1 = new Thread(r1, "T1"); // NEW
        Thread t2 = new Thread(r1, "T2"); // NEW

        t1.start(); // NEW -> RUNNABLE
        t2.start(); // NEW -> RUNNABLE

        System.out.println("END !! " + Thread.currentThread().getName());
    }
}

/*
OUTPUT
END !! main
1 T1
1 T2
3 T1
3 T2
5 T2
5 T1
7 T2
7 T1
9 T2
9 T1
11 T2
11 T1
*/
