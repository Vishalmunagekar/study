package com.thread.executorservices.filehandling;

import java.util.List;

public class example2 {
//    private static final int NUM_CUSTOMERS = 1000000000;
    private static final int NUM_CUSTOMERS = 10000000;
    private static final int NUM_THREADS = 4; // Number of threads for processing

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

//        MyFileWriter fileHandling = new MyFileWriter();
//        List<Customer> customers = fileHandling.generateCustomers(NUM_CUSTOMERS);
        String filename = "customers.txt";
//        fileHandling.createCustomerFile(customers, filename);

        MyFileReader myFileReader = new MyFileReader();
        myFileReader.readCustomersFromFile(filename);

        long endTime = System.currentTimeMillis();
        printResult(startTime, endTime);
    }

    public static void printResult(long startTime, long endTime){
        long totalTimeMilliseconds = endTime - startTime; // Total time in milliseconds
        long totalTimeSeconds = totalTimeMilliseconds / 1000; // Convert milliseconds to seconds
        long remainingMilliseconds = totalTimeMilliseconds % 1000; // Remaining milliseconds

        System.out.println("Total time taken: " + totalTimeSeconds + " seconds and " + remainingMilliseconds + " milliseconds");
    }

}
