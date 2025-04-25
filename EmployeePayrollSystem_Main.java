
/* 5  Employee Payroll System (Abstraction) Create an abstract class Employee with abstract methods calculateSalary() and getDetails(). Extend it with FullTimeEmployee and Freelancer classes, each with their own salary calculation logic. */

// Abstract class: You can't create an object of this class directly
abstract class Employee {
    protected String name;
    protected int id;

    // Constructor to initialize common data
    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Abstract method: must be implemented by subclasses
    public abstract double calculateSalary();

    // Abstract method: must be implemented by subclasses
    public abstract void getDetails();
}

// Full-time employee class
class FullTimeEmployee extends Employee {
    private double monthlySalary;

    // Constructor
    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);  // Call parent constructor
        this.monthlySalary = monthlySalary;
    }

    // Implement abstract method: salary is fixed
    public double calculateSalary() {
        return monthlySalary;
    }

    // Implement abstract method: show employee details
    public void getDetails() {
        System.out.println("Full-Time Employee");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Monthly Salary: ₹" + calculateSalary());
        System.out.println();
    }
}

// Freelancer class
class Freelancer extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    // Constructor
    public Freelancer(String name, int id, double hourlyRate, int hoursWorked) {
        super(name, id);  // Call parent constructor
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    // Implement abstract method: salary = rate * hours
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    // Implement abstract method: show employee details
    public void getDetails() {
        System.out.println("Freelancer");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Hourly Rate: ₹" + hourlyRate);
        System.out.println("Total Salary: ₹" + calculateSalary());
        System.out.println();
    }
}

// Main class to test everything
public class EmployeePayrollSystem_Main {
    public static void main(String[] args) {
        // Create array of type Employee to store different employee types
        Employee[] employees = new Employee[2];

        // Add one full-time and one freelancer
        employees[0] = new FullTimeEmployee("Amit Sharma", 101, 45000);
        employees[1] = new Freelancer("Riya Mehta", 202, 500, 120);

        // Loop through and print details using polymorphism
        System.out.println("EMPLOYEE PAYROLL SYSTEM\n");
        for (int i = 0; i < employees.length; i++) {
            employees[i].getDetails();  // This will call correct version based on actual object
        }
    }
}
