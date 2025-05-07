package Functional_Programming_Assignment.level1.level6;

import java.util.*;
import java.util.stream.Collectors;

// StaffMember class with name, department, and salary
class StaffMember {
    private String name;
    private String department;
    private double salary;

    // Constructor
    public StaffMember(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getter for department
    public String getDepartment() {
        return department;
    }

    // Getter for salary
    public double getSalary() {
        return salary;
    }
}

public class AverageSalaryByDept {
    public static void main(String[] args) {

        // Sample staff list
        List<StaffMember> staffList = Arrays.asList(
                new StaffMember("Alice", "HR", 50000),
                new StaffMember("Bob", "IT", 60000),
                new StaffMember("Charlie", "HR", 55000),
                new StaffMember("David", "Finance", 70000),
                new StaffMember("Eve", "IT", 65000)
        );

        // Calculate average salary by department using Stream and Collectors
        Map<String, Double> averageSalaryByDept = staffList.stream()
                .collect(Collectors.groupingBy(
                        StaffMember::getDepartment,                         // Group by department
                        Collectors.averagingDouble(StaffMember::getSalary)  // Average of salaries
                ));

        // Print the result
        System.out.println("Average Salary by Department:");
        for (Map.Entry<String, Double> entry : averageSalaryByDept.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
