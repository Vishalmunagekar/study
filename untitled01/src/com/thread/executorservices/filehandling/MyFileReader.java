package com.thread.executorservices.filehandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MyFileReader {

//    public static void readCustomersFromFile(String filename) {
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String finalLine = line;
//                Future<?> submit = executorService.submit(() -> {
//                    Customer customer = parseCustomerFromString(finalLine);
////                    System.out.println("thread : " + Thread.currentThread().getName());
//                });
//            }
//            System.out.println("While loop ended!!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        finally {
//            executorService.shutdown();
//        }
//    }

    public static void readCustomersFromFile(String filename) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Callable<Customer>> tasks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String finalLine = line;
                tasks.add(()->{
                    return parseCustomerFromString(finalLine);
                });
            }
            try{
                List<Future<Customer>> futures = executorService.invokeAll(tasks);
                executorService.shutdown();
                for (Future<Customer> future : futures) {
                    future.get(); // Wait for completion of all tasks
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
            System.out.println("While loop ended!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            executorService.shutdown();
        }
    }

    private static Customer parseCustomerFromString(String line) {
        DecimalFormat df = new DecimalFormat("#.##");
        String[] parts = line.split(",");
        long id = Long.parseLong(parts[0]);
        String name = parts[1];
        char gender = parts[2].charAt(0);
        String city = parts[3];
        double oldBalance = Double.parseDouble(parts[4]);
        double currentBill = Double.parseDouble(parts[5]);
        double totalBill = Double.parseDouble(df.format(oldBalance + currentBill));
        String contactNumber = parts[6];
        String email = parts[7];
        long purchaseDate = Long.parseLong(parts[8]);
        return new Customer(id, name, gender, city, oldBalance, currentBill, contactNumber, email, purchaseDate, totalBill);
    }

}
