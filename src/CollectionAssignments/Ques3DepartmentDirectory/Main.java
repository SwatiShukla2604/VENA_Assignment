/**  Problem 3: Department Directory with Sorted Employees (Map, List)
 Maintain a Map<String, List<Employee>> where the key is department name.
 •	Sort each department’s employees by salary descending.
 •	Provide a method to return top N paid employees across all departments.
    */

package CollectionAssignments.Ques3DepartmentDirectory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DepartmentDirectory directory = new DepartmentDirectory();

        //  Add employees
        directory.addEmployee(new Employee("Alice", 75000, "HR"));
        directory.addEmployee(new Employee("Bob",120000 , "IT"));
        directory.addEmployee(new Employee("Eve", 95000,  "Finance"));
        directory.addEmployee(new Employee("Charlie", 105000,  "IT"));
        directory.addEmployee(new Employee("Diana", 80000,  "HR"));

        //  Sort employees by salary (within each department)
        directory.sortDepartmentsBySalary();

        //  Print all departments and their employees
        directory.printDepartmentDirectory();

        //  Get top 3 paid employees
        List<Employee> topEmployees = directory.getTopNPaidEmployees(3);
        System.out.println("\nTop 3 Paid Employees Across All Departments:");
        for (Employee emp : topEmployees) {
            System.out.println(emp);
        }
    }
}

