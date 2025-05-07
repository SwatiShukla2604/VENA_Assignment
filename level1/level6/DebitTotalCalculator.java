// Level 6 - Question 1
// Given a list of transactions (with amount and type), calculate the total amount for type "DEBIT" using streams.

package Functional_Programming_Assignment.level1.level6;

import java.util.*;

class Transaction {
    private double amount;
    private String type;

    public Transaction(double amount, String type) {
        this.amount = amount;
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }
}

public class DebitTotalCalculator {
    public static void main(String[] args) {
        try {
            // Sample list of transactions
            List<Transaction> transactions = Arrays.asList(
                    new Transaction(100.0, "DEBIT"),
                    new Transaction(200.0, "CREDIT"),
                    new Transaction(300.0, "DEBIT"),
                    new Transaction(150.0, "DEBIT")
            );

            // Check for null or empty list
            if (transactions == null || transactions.isEmpty()) {
                System.out.println("No transactions to process.");
                return;
            }

            // Stream to filter DEBIT transactions and sum their amounts
            double totalDebitAmount = transactions.stream()
                    .filter(txn -> "DEBIT".equalsIgnoreCase(txn.getType())) // keep only DEBIT
                    .mapToDouble(Transaction::getAmount) // get amount
                    .sum(); // sum all debit amounts

            System.out.println("Total DEBIT amount: " + totalDebitAmount);

        } catch (Exception e) {
            System.out.println("Error occurred while calculating DEBIT total: " + e.getMessage());
        }
    }
}
