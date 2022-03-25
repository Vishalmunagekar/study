package com.thread.synchronize.solution;

public class Consumer extends Thread {

    public Consumer(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            synchronized (Main.bucket) {
                if(!Main.bucket.isEmpty()){
                    Integer n = Main.bucket.get(0);
                    Main.bucket.remove(0);
                    System.out.println(Thread.currentThread().getName() + " took value " + n + " from the bucket.");
                }
            }
        }
    }
}
