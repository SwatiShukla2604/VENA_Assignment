package Assignment2;

// Responsible for printing transaction logs (not storing them)
public class TransactionLogger {

    // Thread-safe print method to avoid log overlap in console
    public static synchronized void print(String accountNumber, Transaction txn) {
        System.out.println("Account: " + accountNumber + " | " + txn);
    }
}
