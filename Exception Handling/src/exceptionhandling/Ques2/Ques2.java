package exceptionhandling.Ques2;

// Question 2: Custom exception with hierarchy
// Define a base custom exception BankingException and two subclasses: InsufficientFundsException and InvalidAccountException.
// Write a method transferFunds() that can throw either.
// Demonstrate catching them separately and together (by catching the parent).

// Base exception class
class BankingException extends Exception {
    public BankingException(String message) {
        super(message);
    }
}

// Subclass for insufficient funds error
class InsufficientFundsException extends BankingException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// Subclass for invalid account error
class InvalidAccountException extends BankingException {
    public InvalidAccountException(String message) {
        super(message);
    }
}

// Bank class simulating funds transfer
class Bank {
    private double balance;

    public Bank(double balance) {
        this.balance = balance;
    }

    // Method to transfer funds
    public void transferFunds(double amount, String accountId) throws InsufficientFundsException, InvalidAccountException {
        // Simulating Invalid Account
        if (accountId == null || accountId.isEmpty()) {
            throw new InvalidAccountException("Account ID is invalid.");
        }

        // Simulating Insufficient Funds
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for the transfer.");
        }

        // Otherwise, process the transfer
        balance -= amount;
        System.out.println("Transfer successful! Remaining balance: " + balance);
    }
}

// Main class to demonstrate the custom exceptions
public class Ques2 {
    public static void main(String[] args) {
        Bank bankAccount = new Bank(1000.00); // A bank account with an initial balance of 1000

        // Catching exceptions separately (by type)
        try {
            // Trying an invalid account ID
            bankAccount.transferFunds(500.00, "");
        } catch (InvalidAccountException e) {
            System.out.println("Caught InvalidAccountException: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("Caught InsufficientFundsException: " + e.getMessage());
        }

        // Catching exceptions together (by parent class)
        try {
            // Trying insufficient funds
            bankAccount.transferFunds(1500.00, "12345");
        } catch (BankingException e) {
            System.out.println("Caught BankingException: " + e.getMessage());
        }

        // Catching InsufficientFundsException separately
        try {
            // Trying a successful transfer
            bankAccount.transferFunds(200.00, "12345");
        } catch (InvalidAccountException e) {
            System.out.println("Caught InvalidAccountException: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("Caught InsufficientFundsException: " + e.getMessage());
        }
    }
}
