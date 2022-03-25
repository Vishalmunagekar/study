package com.thread.jointhread;

public class DB1Query implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println("DB1Query has been completed...!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
