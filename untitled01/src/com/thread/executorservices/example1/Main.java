package com.thread.executorservices.example1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
            for(int i = 1; i <= 10; i++){
                int taskNumber = i;
             // executor.submit(()->{  // return Future<?>
                executor.execute(()->{ // return void
                    try {
                        Thread.sleep(3000);
                        System.out.println("Task " + taskNumber + " executed by " + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
            executor.shutdown();
    }
}
