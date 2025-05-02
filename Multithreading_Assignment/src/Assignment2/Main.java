/** Assignment 2: Bank Account Synchronization
 Background:
 Simulate a multi-threaded banking system that supports concurrent deposits and withdrawals from shared accounts.
 Requirements:
 Implement a BankAccount class with:
 Methods: deposit(double amount), withdraw(double amount)
 Thread-safe balance modification
 Create multiple threads representing users performing deposits and withdrawals
 Ensure no overdrawing and correct final balance
 Bonus Requirements:
 Add transaction logging
 Add per-account lock to prevent locking the entire bank*/


/** Threads don’t depend on each other — if a withdrawal fails due to low balance, we just return without waiting.

 Using wait() would make the thread pause until another thread deposits, which is unnecessary for this assignment's logic.*/

package Assignment2;

// Main simulation class with multiple threads for each account
public class Main {
    public static void main(String[] args) {

        // Creating two bank accounts
        BankAccount acc1 = new BankAccount("ACC101", 1000);
        BankAccount acc2 = new BankAccount("ACC202", 2000);

        // Threads for acc1
        Thread t1 = new Thread(() -> {
            acc1.deposit(500);
            acc1.withdraw(300);
        });

        Thread t2 = new Thread(() -> {
            acc1.withdraw(800);
            acc1.deposit(200);
        });

        // Threads for acc2
        Thread t3 = new Thread(() -> {
            acc2.withdraw(2500); // Should fail due to insufficient funds
            acc2.deposit(1000);
        });

        Thread t4 = new Thread(() -> {
            acc2.deposit(300);
            acc2.withdraw(500);
        });

        // Start all threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Wait for threads to complete
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print final balances
        System.out.println("\n--- Final Balances ---");
        System.out.println(acc1.getAccountNumber() + ": " + acc1.getBalance());
        System.out.println(acc2.getAccountNumber() + ": " + acc2.getBalance());

        // Print stored transaction logs
        System.out.println("\n--- Transaction Logs ---");
        acc1.printTransactionHistory();
        acc2.printTransactionHistory();
    }
}

