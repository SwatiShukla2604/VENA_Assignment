package CollectionAssignments.Ques3DepartmentDirectory;

/**
 * A simple class to represent an Employee.
 * Each employee has a name, salary, and department.
 */
public class Employee {
    private String name;
    private double salary;
    private String department;

    // Constructor to initialize the employee
    public Employee(String name, double salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    // Getter for employee name
    public String getName() {
        return name;
    }

    // Getter for employee salary
    public double getSalary() {
        return salary;
    }

    // Getter for employee department
    public String getDepartment() {
        return department;
    }

    // Override toString() to display employee info neatly when printing
    @Override
    public String toString() {
        return name + " | " + department + " | $" + salary;
    }
}

