package com.thread.threadclassimpl;

public class EvenNumberThread extends Thread {

    @Override
    public void run() {
        for(int i = 0;i <= 10; i += 2 ) {
            System.out.println(i + " " +Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
