package com.thread.jointhread;

public class Main {
    public static void main(String[] args) {
        Runnable r1 = new DB1Query();
        Runnable r2 = new DB2Query();

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();

        try {
            t1.join(); // current Thread (main) will wait for this thread (t1) complete its process.
            t2.join(); // current Thread (main) will wait for this thread (t2) complete its process.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("PROCESSING....!!!");
    }
}

/*
OUTPUT

without calling join()
PROCESSING....!!!
DB2Query has been completed...!!!
DB1Query has been completed...!!

with calling join()
DB2Query has been completed...!!!
DB1Query has been completed...!!!
PROCESSING....!!!

*/