package com.company;

import java.util.Scanner;

public class AccountTest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Account newAcc = new Account("", 0);
        Account account1 = new Account("Jane Greene", 50.00);
        Account account2 = new Account("John Blue", -7.53);

        System.out.printf("Initial name is: %s%n%n", newAcc.getName());

        System.out.println("Please enter name: ");
        String userInput = input.nextLine();
        newAcc.setName(userInput);
        System.out.println();

        System.out.printf("Name in the object newAcc is:%n%S%n", newAcc.getName());

        System.out.printf("%s balance: $%.2f%n", account1.getName(), account1.getBalance());
        System.out.printf("%s balance: $%.2f%n", account2.getName(), account2.getBalance());

        System.out.print("Enter deposit amount for account1: ");
        double depositAmount = input.nextDouble();
        System.out.printf("%nAdding %.2f to account1 balance:  %.2f%n%n", depositAmount, account1.getBalance());
        account1.deposit(depositAmount);

        System.out.printf("%s, balance: $%.2f%n", account1.getName(), account1.getBalance());


        System.out.print("Enter withdraw amount for account1: ");
        double withdrawAmount = input.nextDouble();

        account1.withdraw(withdrawAmount);

        System.out.printf("%nWithdrawing %.2f to account1 balance:  %.2f%n%n", withdrawAmount, account1.getBalance());

    }
}
