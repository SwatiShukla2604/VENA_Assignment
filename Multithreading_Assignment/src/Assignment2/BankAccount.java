package Assignment2;

import java.util.ArrayList;
import java.util.List;

// Represents a single bank account with thread-safe operations
public class BankAccount {
    private final String accountNumber;
    private double balance;

    // Lock object for per-account synchronization
    private final Object lock = new Object();

    // List to store all transactions
    private final List<Transaction> transactionLog = new ArrayList<>();

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Deposit method with per-account locking
    public void deposit(double amount) {
        synchronized (lock) {
            balance += amount;

            // Create transaction, save it, and print
            Transaction txn = new Transaction("Deposit", amount, balance);
            transactionLog.add(txn);
            TransactionLogger.print(accountNumber, txn);
        }
    }

    // Withdraw method with overdraft check and per-account locking
    public void withdraw(double amount) {
        synchronized (lock) {
            if (balance >= amount) {
                balance -= amount;
                Transaction txn = new Transaction("Withdraw", amount, balance);
                transactionLog.add(txn);
                TransactionLogger.print(accountNumber, txn);
            } else {
                Transaction txn = new Transaction("Withdraw-Failed", amount, balance);
                transactionLog.add(txn);
                TransactionLogger.print(accountNumber, txn);
            }
        }
    }

    // Getter for balance
    public double getBalance() {
        synchronized (lock) {
            return balance;
        }
    }

    // Getter for account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Print all saved transaction logs
    public void printTransactionHistory() {
        synchronized (lock) {
            System.out.println("\nTransaction History for Account: " + accountNumber);
            for (Transaction txn : transactionLog) {
                System.out.println(txn);
            }
        }
    }
}
