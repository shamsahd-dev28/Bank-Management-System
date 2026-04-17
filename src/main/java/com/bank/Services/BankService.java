package com.bank.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bank.models.Account;

public class BankService {
    private List<Account> accounts;
    private Scanner scanner;

    public BankService() {
        accounts = new ArrayList<>();
        scanner = new Scanner(System.in);
        // Sample data
        accounts.add(new Account("ACC001", "John Doe", 5000.0, "Savings"));
        accounts.add(new Account("ACC002", "Jane Smith", 7500.0, "Current"));
    }

    public void createAccount() {
        System.out.print("Enter Account Number: ");
        String accNo = scanner.nextLine();
        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Initial Balance: $");
        double balance = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        System.out.print("Enter Account Type (Savings/Current): ");
        String type = scanner.nextLine();

        Account account = new Account(accNo, name, balance, type);
        accounts.add(account);
        System.out.println("✅ Account created successfully!");
    }

    public void deposit() {
        System.out.print("Enter Account Number: ");
        String accNo = scanner.nextLine();
        Account account = findAccount(accNo);
        
        if (account != null) {
            System.out.print("Enter Deposit Amount: $");
            double amount = scanner.nextDouble();
            account.setBalance(account.getBalance() + amount);
            System.out.println("✅ Deposited $" + amount + ". New Balance: $" + account.getBalance());
        } else {
            System.out.println("❌ Account not found!");
        }
    }

    public void withdraw() {
        System.out.print("Enter Account Number: ");
        String accNo = scanner.nextLine();
        Account account = findAccount(accNo);
        
        if (account != null) {
            System.out.print("Enter Withdraw Amount: $");
            double amount = scanner.nextDouble();
            if (account.getBalance() >= amount) {
                account.setBalance(account.getBalance() - amount);
                System.out.println("✅ Withdrawn $" + amount + ". New Balance: $" + account.getBalance());
            } else {
                System.out.println("❌ Insufficient balance!");
            }
        } else {
            System.out.println("❌ Account not found!");
        }
    }

    public void transfer() {
        System.out.print("Enter From Account Number: ");
        String fromAcc = scanner.nextLine();
        System.out.print("Enter To Account Number: ");
        String toAcc = scanner.nextLine();
        
        Account fromAccount = findAccount(fromAcc);
        Account toAccount = findAccount(toAcc);
        
        if (fromAccount != null && toAccount != null) {
            System.out.print("Enter Transfer Amount: $");
            double amount = scanner.nextDouble();
            if (fromAccount.getBalance() >= amount) {
                fromAccount.setBalance(fromAccount.getBalance() - amount);
                toAccount.setBalance(toAccount.getBalance() + amount);
                System.out.println("✅ Transfer successful!");
                System.out.println("From: " + fromAccount);
                System.out.println("To: " + toAccount);
            } else {
                System.out.println("❌ Insufficient balance!");
            }
        } else {
            System.out.println("❌ One or both accounts not found!");
        }
    }

    public void showAllAccounts() {
        System.out.println("\n📋 ALL ACCOUNTS:");
        System.out.println("=".repeat(60));
        for (Account acc : accounts) {
            System.out.println(acc);
        }
    }

    private Account findAccount(String accNo) {
        return accounts.stream()
                .filter(acc -> acc.getAccountNumber().equals(accNo))
                .findFirst()
                .orElse(null);
    }
}