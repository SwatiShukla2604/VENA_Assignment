/* Banking System*/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract Account class (demonstrates abstraction and inheritance)
abstract class Account {
    private String accountNumber;
    private Customer customer;
    private double balance;
    
    // Constructor
    public Account(String accountNumber, Customer customer, double balance) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = balance;
    }
    
    // Getters (encapsulation)
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public Customer getCustomer() {
        return customer;
    }
    
    public double getBalance() {
        return balance;
    }
    
    // Protected setter for balance (encapsulation with controlled access)
    protected void setBalance(double balance) {
        this.balance = balance;
    }
    
    // Deposit method (common behavior)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }
    
    // Abstract withdraw method (abstraction - implementation left to subclasses)
    public abstract boolean withdraw(double amount);
    
    // Transfer method (demonstrates method implementation in abstract class)
    public boolean transfer(Account toAccount, double amount) {
        if (this.withdraw(amount)) {
            toAccount.deposit(amount);
            return true;
        }
        return false;
    }
}

// SavingsAccount class (demonstrates inheritance and method overriding)
class SavingsAccount extends Account {
    private double interestRate;
    
    // Constructor
    public SavingsAccount(String accountNumber, Customer customer, double balance, double interestRate) {
        super(accountNumber, customer, balance); // Calling parent class constructor
        this.interestRate = interestRate;
    }
    
    // Method to calculate interest (specific to SavingsAccount)
    public void calculateInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest);
    }
    
    // Overriding withdraw method (polymorphism)
    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= getBalance()) {
            setBalance(getBalance() - amount);
            return true;
        }
        return false;
    }
}

// CheckingAccount class (demonstrates inheritance and method overriding)
class CheckingAccount extends Account {
    private double overdraftLimit;
    
    // Constructor
    public CheckingAccount(String accountNumber, Customer customer, double balance, double overdraftLimit) {
        super(accountNumber, customer, balance); // Calling parent class constructor
        this.overdraftLimit = overdraftLimit;
    }
    
    // Overriding withdraw method (polymorphism)
    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && (getBalance() + overdraftLimit) >= amount) {
            setBalance(getBalance() - amount);
            return true;
        }
        return false;
    }
}

// Customer class (demonstrates encapsulation and association)
class Customer {
    private String customerId;
    private String name;
    private String email;
    private List<Account> accounts;
    
    // Constructor
    public Customer(String customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.accounts = new ArrayList<>();
    }
    
    // Getters (encapsulation)
    public String getCustomerId() {
        return customerId;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    // Method to add account (association)
    public void addAccount(Account account) {
        accounts.add(account);
    }
    
    // Method to find account by account number
    public Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
    
    // Method to display customer details
    public void displayDetails() {
        System.out.println("\nCustomer Details:");
        System.out.println("ID: " + customerId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("\nAccounts:");
        for (Account account : accounts) {
            System.out.println(account.getAccountNumber() + " - " + 
                              account.getClass().getSimpleName() + " - Balance: " + account.getBalance());
        }
    }
}

// Bank class (demonstrates encapsulation and composition)
class Bank {
    private String name;
    private List<Customer> customers;
    
    // Constructor
    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }
    
    // Getter for name (encapsulation)
    public String getName() {
        return name;
    }
    
    // Method to add customer (composition)
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    
    // Method to find customer by ID
    public Customer findCustomer(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }
    
    // Method to find account by account number
    public Account findAccount(String accountNumber) {
        for (Customer customer : customers) {
            Account account = customer.findAccount(accountNumber);
            if (account != null) {
                return account;
            }
        }
        return null;
    }
}

// Main class to demonstrate the banking system
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("MyBank");
        Scanner scanner = new Scanner(System.in);
        
        // Adding some sample customers and accounts
        Customer customer1 = new Customer("C001", "John Doe", "john@example.com");
        Customer customer2 = new Customer("C002", "Jane Smith", "jane@example.com");
        
        bank.addCustomer(customer1);
        bank.addCustomer(customer2);
        
        // Creating different types of accounts (demonstrating polymorphism)
        Account johnSavings = new SavingsAccount("SA001", customer1, 1000, 0.05);
        Account johnChecking = new CheckingAccount("CA001", customer1, 500, 200);
        Account janeSavings = new SavingsAccount("SA002", customer2, 2000, 0.03);
        
        customer1.addAccount(johnSavings);
        customer1.addAccount(johnChecking);
        customer2.addAccount(janeSavings);
        
        // Bank operations menu
        while (true) {
            System.out.println("\nWelcome to " + bank.getName());
            System.out.println("1. View Customer Details");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Calculate Interest (Savings)");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    // View customer details
                    System.out.print("Enter customer ID: ");
                    String custId = scanner.next();
                    Customer cust = bank.findCustomer(custId);
                    if (cust != null) {
                        cust.displayDetails();
                    } else {
                        System.out.println("Customer not found!");
                    }
                    break;
                    
                case 2:
                    // Deposit
                    System.out.print("Enter account number: ");
                    String accNo = scanner.next();
                    System.out.print("Enter amount to deposit: ");
                    double amount = scanner.nextDouble();
                    Account acc = bank.findAccount(accNo);
                    if (acc != null) {
                        acc.deposit(amount);
                        System.out.println("Deposit successful. New balance: " + acc.getBalance());
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;
                    
                case 3:
                    // Withdraw
                    System.out.print("Enter account number: ");
                    accNo = scanner.next();
                    System.out.print("Enter amount to withdraw: ");
                    amount = scanner.nextDouble();
                    acc = bank.findAccount(accNo);
                    if (acc != null) {
                        if (acc.withdraw(amount)) {
                            System.out.println("Withdrawal successful. New balance: " + acc.getBalance());
                        } else {
                            System.out.println("Withdrawal failed. Insufficient funds or limit exceeded.");
                        }
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;
                    
                case 4:
                    // Transfer
                    System.out.print("Enter source account number: ");
                    String fromAccNo = scanner.next();
                    System.out.print("Enter destination account number: ");
                    String toAccNo = scanner.next();
                    System.out.print("Enter amount to transfer: ");
                    amount = scanner.nextDouble();
                    
                    Account fromAcc = bank.findAccount(fromAccNo);
                    Account toAcc = bank.findAccount(toAccNo);
                    
                    if (fromAcc != null && toAcc != null) {
                        if (fromAcc.transfer(toAcc, amount)) {
                            System.out.println("Transfer successful.");
                            System.out.println("Source account balance: " + fromAcc.getBalance());
                            System.out.println("Destination account balance: " + toAcc.getBalance());
                        } else {
                            System.out.println("Transfer failed. Insufficient funds or limit exceeded.");
                        }
                    } else {
                        System.out.println("One or both accounts not found!");
                    }
                    break;
                    
                case 5:
                    // Calculate interest (demonstrating polymorphism)
                    System.out.print("Enter savings account number: ");
                    accNo = scanner.next();
                    acc = bank.findAccount(accNo);
                    if (acc instanceof SavingsAccount) {
                        SavingsAccount savingsAcc = (SavingsAccount) acc; // Downcasting
                        savingsAcc.calculateInterest();
                        System.out.println("Interest calculated. New balance: " + savingsAcc.getBalance());
                    } else {
                        System.out.println("Account is not a savings account or not found!");
                    }
                    break;
                    
                case 6:
                    System.out.println("Thank you for using our banking system!");
                    scanner.close();
                    System.exit(0);
                    
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}