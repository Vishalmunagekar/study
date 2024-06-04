package com.thread.executorservices.filehandling;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyFileWriter {
    private static final long STARTING_ID = 100001;
    public static void createCustomerFile(List<Customer> customers, String filename) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){
            for (Customer customer : customers) {
                writer.write( customer + "\n");
            }
            writer.close();
            System.out.println("Customer file created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Customer> generateCustomers(int numCustomers) {
        List<Customer> customers = new ArrayList<>();
        Random random = new Random();
        DecimalFormat df = new DecimalFormat("#.##");

        // Generating customers with random data
        for (int i = 0; i < numCustomers; i++) {
            long id = STARTING_ID + i; // Sequential 10-digit ID
            String name = "Customer" + id;
            char gender = random.nextBoolean() ? 'M' : 'F';
            String city = "City" + (random.nextInt(5) + 1);
            double oldBalance = Double.parseDouble(df.format(random.nextDouble() * 10000)); // Random old balance
            double currentBill = Double.parseDouble(df.format(random.nextDouble() * 5000)); // Random current bill
            String contactNumber = generateContactNumber(); // Random contact number
            String email = "customer" + id + "@example.com";
            long purchaseDate = System.currentTimeMillis() - random.nextInt(86400000); // Random date within last 24 hours
            Customer customer = new Customer(id, name, gender, city, oldBalance, currentBill, contactNumber, email, purchaseDate);
//            System.out.println(customer);
            customers.add(customer);
        }
        return customers;
    }

    private static String generateContactNumber() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(10)); // Generate digits randomly
        }
        return sb.toString();
    }
}
