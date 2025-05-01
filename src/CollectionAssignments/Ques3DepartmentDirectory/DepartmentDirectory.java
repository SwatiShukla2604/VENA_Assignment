package CollectionAssignments.Ques3DepartmentDirectory;

import java.util.*;

/**
 * This class manages employees grouped by departments.
 * It provides functionality to:
 *  - Add employees
 *  - Sort them by salary (per department)
 *  - Get top N highest-paid employees across all departments
 */
public class DepartmentDirectory {

    // Map to store department → list of employees in that department
    private Map<String, List<Employee>> departmentMap = new HashMap<>();

    /**
     * Add a new employee to their respective department
     * If the department doesn't exist yet, it creates a new list
     *
     * @param emp The Employee object to add
     */
    public void addEmployee(Employee emp) {
        departmentMap.putIfAbsent(emp.getDepartment(), new ArrayList<>());
        departmentMap.get(emp.getDepartment()).add(emp);
    }

    /**
     * Sort each department's employee list by salary (descending order)
     */
    public void sortDepartmentsBySalary() {
        for (List<Employee> empList : departmentMap.values()) {
            empList.sort((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
        }
    }

    /**
     * Print each department and its list of employees (sorted or unsorted)
     */
    public void printDepartmentDirectory() {
        for (Map.Entry<String, List<Employee>> entry : departmentMap.entrySet()) {
            String dept = entry.getKey();
            List<Employee> employees = entry.getValue();

            System.out.println("\nDepartment: " + dept);
            for (Employee emp : employees) {
                System.out.println(emp); // Uses toString() of Employee
            }
        }
    }

    /**
     * This method returns the top N highest-paid employees across all departments.
     * It uses a PriorityQueue (Max-Heap) to efficiently find and return top salaries.
     *
     * @param n Number of top-paid employees to return (using wrapper class Integer, not primitive int)
     * @return List of top N paid employees
     */
    public List<Employee> getTopNPaidEmployees(Integer n) {
        // Max-Heap to always keep the employee with the highest salary at the top
        PriorityQueue<Employee> maxHeap = new PriorityQueue<>(
                (e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary())
        );

        // Add all employees from all departments into one big max-heap
        for (List<Employee> employeeList : departmentMap.values()) {
            maxHeap.addAll(employeeList);
        }

        // Prepare result list
        List<Employee> result = new ArrayList<>();

        // Poll top N employees (highest salaries)
        for (Integer i = 0; i < n && !maxHeap.isEmpty(); i++) {
            result.add(maxHeap.poll());
        }

        return result;
    }
}

