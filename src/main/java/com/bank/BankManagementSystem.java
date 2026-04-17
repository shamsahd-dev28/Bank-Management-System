package com.bank;

import java.util.Scanner;

import com.bank.services.BankService;

public class BankManagementSystem {
    public static void main(String[] args) {
        BankService bankService = new BankService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("🏦 Welcome to XYZ Bank Management System!");
        System.out.println("=".repeat(50));

        while (true) {
            System.out.println("\n📋 Choose an option:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Funds");
            System.out.println("5. Show All Accounts");
            System.out.println("6. Exit");
            
            System.out.print("Enter choice (1-6): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    bankService.createAccount();
                    break;
                case 2:
                    bankService.deposit();
                    break;
                case 3:
                    bankService.withdraw();
                    break;
                case 4:
                    bankService.transfer();
                    break;
                case 5:
                    bankService.showAllAccounts();
                    break;
                case 6:
                    System.out.println("👋 Thank you for using XYZ Bank!");
                    System.exit(0);
                default:
                    System.out.println("❌ Invalid choice! Try again.");
            }
        }
    }
}