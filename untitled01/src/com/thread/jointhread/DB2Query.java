package com.thread.jointhread;

public class DB2Query implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("DB2Query has been completed...!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
