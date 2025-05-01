package CollectionAssignments.Ques10BankTransactionLog;

import java.time.LocalDateTime;
import java.util.*;

public class BankTransactionLog {

    // This Map stores account number as key and list of transactions as value
    private Map<String, List<Transaction>> transactionMap;

    public BankTransactionLog() {
        transactionMap = new HashMap<>();
    }

    // Method to add a transaction
    public void addTransaction(String accountNumber, Double amount, String type) {
        if (accountNumber == null || amount == null || type == null) {
            System.out.println("Error: Transaction fields cannot be null.");
            return;
        }

        // Create a new transaction with current time
        Transaction transaction = new Transaction(accountNumber, amount, type, LocalDateTime.now());

        // Get the list from map or create a new one if account not present
        List<Transaction> transactions = transactionMap.getOrDefault(accountNumber, new ArrayList<>());

        // Add the transaction to the list
        transactions.add(transaction);

        // Put the updated list back in the map
        transactionMap.put(accountNumber, transactions);
    }

    // Method to generate and print a bank statement
    public void generateStatement(String accountNumber) {
        List<Transaction> transactions = transactionMap.get(accountNumber);

        if (transactions == null || transactions.isEmpty()) {
            System.out.println("No transactions found for account number: " + accountNumber);
            return;
        }

        // Sort the transactions by timestamp
        transactions.sort(Comparator.comparing(Transaction::getTimestamp));

        System.out.println("Bank Statement for Account: " + accountNumber);
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }
}

