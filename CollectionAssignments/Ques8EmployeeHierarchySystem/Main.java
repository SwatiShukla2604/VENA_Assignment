/** Problem 8: Employee Hierarchy System (Map, TreeMap)
 Maintain a hierarchy with Map<Manager, TreeMap<Level, List<Employee>>>.
 •	Print employees reporting to a manager at each level.
 */

package CollectionAssignments.Ques8EmployeeHierarchySystem;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Map to maintain Manager -> (Level -> List of Employees)
        Map<Manager, TreeMap<Integer, List<Employee>>> hierarchy = new HashMap<>();

        // Create some managers
        Manager mgr1 = new Manager("Alice", 101);
        Manager mgr2 = new Manager("Bob", 102);

        // Create some employees
        Employee e1 = new Employee("John", 201);
        Employee e2 = new Employee("Mary", 202);
        Employee e3 = new Employee("Tom", 203);
        Employee e4 = new Employee("Sara", 204);
        Employee e5 = new Employee("Mike", 205);

        // Add employees under Manager 1
        TreeMap<Integer, List<Employee>> mgr1Levels = new TreeMap<>();
        mgr1Levels.put(1, Arrays.asList(e1, e2));  // Level 1 employees under mgr1
        mgr1Levels.put(2, Collections.singletonList(e3));  // Level 2 employee

        // Add employees under Manager 2
        TreeMap<Integer, List<Employee>> mgr2Levels = new TreeMap<>();
        mgr2Levels.put(1, Arrays.asList(e4, e5));  // Level 1 employees under mgr2

        // Put into main hierarchy map
        hierarchy.put(mgr1, mgr1Levels);
        hierarchy.put(mgr2, mgr2Levels);

        // ----------- Display the full hierarchy -----------
        for (Map.Entry<Manager, TreeMap<Integer, List<Employee>>> entry : hierarchy.entrySet()) {
            Manager manager = entry.getKey();
            TreeMap<Integer, List<Employee>> levelMap = entry.getValue();

            System.out.println("\nManager: " + manager.getName() + " (ID: " + manager.getId() + ")");

            // Traverse each level in sorted order (TreeMap keeps levels sorted)
            for (Map.Entry<Integer, List<Employee>> levelEntry : levelMap.entrySet()) {
                int level = levelEntry.getKey();
                List<Employee> employees = levelEntry.getValue();

                System.out.println("  Level " + level + ":");

                // If there are no employees at this level (edge case)
                if (employees == null || employees.isEmpty()) {
                    System.out.println("    [No employees at this level]");
                    continue;
                }

                // Print each employee at this level
                for (Employee emp : employees) {
                    System.out.println("    - " + emp);  // uses toString() of Person
                }
            }
        }
    }
}

