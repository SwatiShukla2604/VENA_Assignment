package CollectionAssignments.Ques10BankTransactionLog;

import java.time.LocalDateTime;

// This class represents a single transaction
public class Transaction {
    private String accountNumber;
    private Double amount;
    private String type; // "credit" or "debit"
    private LocalDateTime timestamp;

    // Constructor
    public Transaction(String accountNumber, Double amount, String type, LocalDateTime timestamp) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.type = type;
        this.timestamp = timestamp;
    }

    // Getters for all fields
    public String getAccountNumber() {
        return accountNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    // For displaying the transaction
    @Override
    public String toString() {
        return timestamp + " | " + type.toUpperCase() + " | " + amount;
    }
}

