/* Write a program that groups a list of employees by joining year, and then finds the max salary in each year.*/


package Functional_Programming_Assignment.level1.level9;

import java.util.*;
import java.util.stream.Collectors;

class EmployeeV2 {
    private String name;
    private int joiningYear;
    private double salary;

    public EmployeeV2(String name, int joiningYear, double salary) {
        this.name = name;
        this.joiningYear = joiningYear;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getJoiningYear() {
        return joiningYear;
    }

    public double getSalary() {
        return salary;
    }

    public String toString() {
        return name + " (Salary: " + salary + ")";
    }
}

public class EmployeeGroupingMaxSalary {

    public static Map<Integer, Optional<EmployeeV2>> groupAndFindMaxSalary(List<EmployeeV2> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        EmployeeV2::getJoiningYear,
                        Collectors.maxBy(Comparator.comparing(EmployeeV2::getSalary))
                ));
    }

    public static void main(String[] args) {
        List<EmployeeV2> employeeList = Arrays.asList(
                new EmployeeV2("Alice", 2020, 60000),
                new EmployeeV2("Bob", 2020, 70000),
                new EmployeeV2("Charlie", 2021, 75000),
                new EmployeeV2("Dave", 2021, 72000),
                new EmployeeV2("Eve", 2022, 68000)
        );

        Map<Integer, Optional<EmployeeV2>> result = groupAndFindMaxSalary(employeeList);

        // Print results
        for (Map.Entry<Integer, Optional<EmployeeV2>> entry : result.entrySet()) {
            System.out.println("Year: " + entry.getKey() + " -> " + entry.getValue().orElse(null));
        }
    }
}
