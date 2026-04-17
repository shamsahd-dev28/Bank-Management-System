package com.bank.models;

public class Account {
    private String accountNumber;
    private String customerName;
    private double balance;
    private String accountType;

    public Account(String accountNumber, String customerName, double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = balance;
        this.accountType = accountType;
    }

    // Getters and Setters
    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
    
    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }

    @Override
    public String toString() {
        return String.format("Account: %s | Name: %s | Balance: $%.2f | Type: %s", 
                           accountNumber, customerName, balance, accountType);
    }
}