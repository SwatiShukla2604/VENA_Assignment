// Question: Given a list of Employee objects, group them by department and count how many employees are in each department.

package Functional_Programming_Assignment.level1.level6;

import java.util.*;
import java.util.stream.Collectors;

// Employee class with name, department, and salary
class Employee {
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getter for department
    public String getDepartment() {
        return department;
    }

    // Optional: toString() for printing
    @Override
    public String toString() {
        return name + " (" + department + ")";
    }
}

public class EmployeeDepartmentCount {
    public static void main(String[] args) {

        // Sample list of employees
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 50000),
                new Employee("Bob", "IT", 60000),
                new Employee("Charlie", "HR", 55000),
                new Employee("David", "Finance", 70000),
                new Employee("Eve", "IT", 65000)
        );

        // Group by department and count employees in each
        Map<String, Long> departmentCount = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,       // Grouping key
                        Collectors.counting()          // Counting elements in each group
                ));

        // Output the result
        System.out.println("Employee count by department:");
        departmentCount.forEach((dept, count) ->
                System.out.println(dept + " : " + count));
    }
}
