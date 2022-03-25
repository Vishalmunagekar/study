package com.thread.threadclassimpl;

public class Main {
    public static void main(String[] args) {
        Thread t1 = new EvenNumberThread();
        t1.run(); // this will handled by main thread
        t1.start(); // this will be handled by new thread
        System.out.println("END!! " + Thread.currentThread().getName() );
    }
}
/*
OUTPUT :
0 main
2 main
4 main
6 main
8 main
10 main
END!! main
0 Thread-0
2 Thread-0
4 Thread-0
6 Thread-0
8 Thread-0
10 Thread-0
 */