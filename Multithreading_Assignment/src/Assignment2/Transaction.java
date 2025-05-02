package Assignment2;

import java.time.LocalDateTime;

// This class represents a single deposit/withdrawal transaction
public class Transaction {
    private final String action;               // e.g., Deposit, Withdraw
    private final double amount;               // How much was transacted
    private final double resultingBalance;     // Balance after the transaction
    private final LocalDateTime timestamp;     // When the transaction happened

    public Transaction(String action, double amount, double resultingBalance) {
        this.action = action;
        this.amount = amount;
        this.resultingBalance = resultingBalance;
        this.timestamp = LocalDateTime.now();  // Current date-time
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] " +
                "Action: " + action +
                ", Amount: " + amount +
                ", Balance After: " + resultingBalance;
    }
}
