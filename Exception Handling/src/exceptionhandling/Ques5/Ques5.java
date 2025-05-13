package exceptionhandling.Ques5;

/**
 * Question 5: Partial transaction rollback on failure
 *
 * Simulate a simple in-memory bank transfer system where moving funds between accounts
 * must rollback if an exception occurs mid-operation (e.g., invalid target account).
 * Use try-catch to ensure that no partial transfer leaves accounts in an inconsistent state.
 */

class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double openingBalance) {
        this.accountNumber = accountNumber;
        this.balance = openingBalance;
    }

    public void deposit(double amount) {
        if (amount < 0) throw new IllegalArgumentException("Can't deposit negative amount");
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) throw new IllegalArgumentException("Insufficient funds");
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

public class Ques5 {

    // Simulate transfer with rollback on failure
    public static void transferFunds(BankAccount source, BankAccount target, double amount) {
        try {
            System.out.println("Starting transfer...");

            // Step 1: Withdraw from source
            source.withdraw(amount);
            System.out.println("Withdrawn " + amount + " from " + source.getAccountNumber());

            // Step 2: Simulate failure (e.g., target is null)
            if (target == null) {
                throw new IllegalArgumentException("Target account is invalid");
            }

            // Step 3: Deposit to target
            target.deposit(amount);
            System.out.println("Deposited " + amount + " to " + target.getAccountNumber());

        } catch (Exception e) {
            System.out.println("Transfer failed: " + e.getMessage());

            // Step 4: Rollback if withdrawal was successful but deposit failed
            // Return money back to source
            if (source != null) {
                System.out.println("Rolling back: returning " + amount + " to " + source.getAccountNumber());
                source.deposit(amount);
            }
        }
    }

    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("A001", 1000);
        BankAccount acc2 = new BankAccount("A002", 500);
        BankAccount invalidAcc = null;

        System.out.println("Before transfer:");
        System.out.println("Acc1 balance: " + acc1.getBalance());
        System.out.println("Acc2 balance: " + acc2.getBalance());

        // Successful transfer
        transferFunds(acc1, acc2, 200);

        System.out.println("\nAfter successful transfer:");
        System.out.println("Acc1 balance: " + acc1.getBalance());
        System.out.println("Acc2 balance: " + acc2.getBalance());

        // Failed transfer (invalid target)
        transferFunds(acc1, invalidAcc, 300);

        System.out.println("\nAfter failed transfer:");
        System.out.println("Acc1 balance: " + acc1.getBalance()); // Should be rolled back
        System.out.println("Acc2 balance: " + acc2.getBalance());
    }
}

