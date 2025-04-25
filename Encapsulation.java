/* 3 Encapsulation with Validation Create a BankAccount class with private fields accountHolder, balance, and accountNumber. Use getters and setters with validation: prevent setting a negative balance.*/
// BankAccount class showing Encapsulation and Validation
class BankAccount {

    // These are private fields — they cannot be accessed directly from outside
    private String accountHolder;
    private double balance;
    private String accountNumber;

    // Constructor to create a new account with all details
    public BankAccount(String accountHolder, double balance, String accountNumber) {
        this.accountHolder = accountHolder;
        setBalance(balance);  // we use setter here so validation applies
        this.accountNumber = accountNumber;
    }

    // ====================
    // GETTERS (for reading values)
    // ====================

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    // ====================
    // SETTERS (for updating values)
    // ====================

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    // This is where we do validation: balance can't be negative
    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;  // valid balance
        } else {
            System.out.println("Error: Balance cannot be negative. Balance not changed.");
        }
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    // A method to display account info (for easy printing)
    public void displayAccountInfo() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: ₹" + balance);
    }
}

// =======================
// MAIN Class to Test Everything
// =======================
public class Encapsulation {
    public static void main(String[] args) {

        // Creating a new BankAccount with valid details
        BankAccount myAccount = new BankAccount("Rahul Sharma", 10000, "ACC123456");

        // Display account info
        System.out.println("Account Created:");
        myAccount.displayAccountInfo();
        System.out.println();

        // Trying to set a negative balance
        System.out.println(" Trying to set negative balance...");
        myAccount.setBalance(-5000);  // This should not work
        System.out.println();

        // Display again to confirm balance didn’t change
        System.out.println("Account Info After Attempting Invalid Balance:");
        myAccount.displayAccountInfo();
    }
}
