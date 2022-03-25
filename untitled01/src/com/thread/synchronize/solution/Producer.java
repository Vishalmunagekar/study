package com.thread.synchronize.solution;

import java.util.Random;

public class Producer extends Thread {

    public Producer(String name) {
        super(name);
    }

    @Override
    public void run() {
        Random r = new Random();
        while (true){
            synchronized (Main.bucket){
                if(Main.bucket.size() < 50){
                    int n = r.nextInt(1000);
                    Main.bucket.add(n);
                    System.out.println(Thread.currentThread().getName() + " added value " + n + " into bucket");
                }
            }
        }
    }
}
