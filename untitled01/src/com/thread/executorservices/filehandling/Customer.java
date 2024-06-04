package com.thread.executorservices.filehandling;

public class Customer {
    private long id;
    private String name;
    private char gender;
    private String city;
    private double oldBalance;
    private double currentBill;
    private String contactNumber;
    private String email;
    private long purchaseDate;

    private double totalBill;

    public Customer(long id, String name, char gender, String city, double oldBalance, double currentBill, String contactNumber, String email, long purchaseDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.city = city;
        this.oldBalance = oldBalance;
        this.currentBill = currentBill;
        this.contactNumber = contactNumber;
        this.email = email;
        this.purchaseDate = purchaseDate;
    }

    public Customer(long id, String name, char gender, String city, double oldBalance, double currentBill, String contactNumber, String email, long purchaseDate, double totalBill) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.city = city;
        this.oldBalance = oldBalance;
        this.currentBill = currentBill;
        this.contactNumber = contactNumber;
        this.email = email;
        this.purchaseDate = purchaseDate;
        this.totalBill=totalBill;
    }

    // Getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getOldBalance() {
        return oldBalance;
    }

    public void setOldBalance(double oldBalance) {
        this.oldBalance = oldBalance;
    }

    public double getCurrentBill() {
        return currentBill;
    }

    public void setCurrentBill(double currentBill) {
        this.currentBill = currentBill;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(long purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }

    @Override
    public String toString() {
        return getId() + "," +
                getName() + "," +
                getGender() + "," +
                getCity() + "," +
                getOldBalance() + "," +
                getCurrentBill() + "," +
                getContactNumber() + "," +
                getEmail() + "," +
                getPurchaseDate() + "," +
                getTotalBill();
    }
}
