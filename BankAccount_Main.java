/* 8  Bank Account (this Keyword) Design a BankAccount class with fields like name, balance, and type. Use this keyword in the constructor and in a method that updates the balance. Show how this resolves variable shadowing. */
// Main.java

// Step 1: Create the BankAccount class
class BankAccount {

    // Fields (also called instance variables)
    private String name;
    private double balance;
    private String type;

    // Constructor with parameters having same names as instance variables
    public BankAccount(String name, double balance, String type) {
        // Using 'this' to refer to instance variables (avoids shadowing)
        this.name = name;       // 'this.name' refers to the class field, 'name' is the parameter
        this.balance = balance;
        this.type = type;
    }

    // Method to update balance (deposit or withdraw)
    public void updateBalance(double amount) {
        // Use 'this' optionally to make it clear you're updating this object's balance
        this.balance += amount;
    }

    // Method to display account info
    public void displayAccountInfo() {
        System.out.println("Account Holder: " + name);
        System.out.println("Account Type: " + type);
        System.out.println("Balance: " + balance);
    }
}

// Step 2: Main class to test everything
public class BankAccount_Main {
    public static void main(String[] args) {

        // Create a BankAccount object
        BankAccount account = new BankAccount("John Doe", 1000.0, "Savings");

        // Show initial account info
        account.displayAccountInfo();

        // Deposit 500 using updateBalance
        account.updateBalance(500.0);

        // Show updated account info
        System.out.println("\nAfter depositing 500:");
        account.displayAccountInfo();

        // Withdraw 300 using updateBalance
        account.updateBalance(-300.0);

        // Show final account info
        System.out.println("\nAfter withdrawing 300:");
        account.displayAccountInfo();
    }
}
