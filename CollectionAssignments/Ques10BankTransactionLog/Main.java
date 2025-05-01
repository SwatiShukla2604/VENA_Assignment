/** Problem 10: Bank Transaction Log (Map, List)
 Track transactions using Map<String, List<Transaction>> keyed by account number.
 •	Generate statements, sort by transaction time.
 */

package CollectionAssignments.Ques10BankTransactionLog;

public class Main {
    public static void main(String[] args) {
        // Create an instance of BankTransactionLog
        BankTransactionLog bankLog = new BankTransactionLog();

        // Add transactions to different accounts
        bankLog.addTransaction("ACC123", 5000.0, "credit");
        bankLog.addTransaction("ACC123", 1500.0, "debit");
        bankLog.addTransaction("ACC456", 8000.0, "credit");

        try {
            // Pause the program for 1 second
            // Thread.sleep(1000) means "wait for 1000 milliseconds (1 second)"
            // We do this so that next transaction gets a different timestamp
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Something went wrong while waiting: " + e.getMessage());
        }

        // Add another transaction after 1 second
        bankLog.addTransaction("ACC123", 2000.0, "credit");

        // Generate statement for ACC123
        System.out.println("\n--- Statement for ACC123 ---");
        bankLog.generateStatement("ACC123");

        // Generate statement for ACC456
        System.out.println("\n--- Statement for ACC456 ---");
        bankLog.generateStatement("ACC456");

        // Try generating statement for an account that does not exist
        System.out.println("\n--- Statement for ACC999 ---");
        bankLog.generateStatement("ACC999");
    }
}
