package CollectionAssignments.Ques8EmployeeHierarchySystem;

// Employee is a type of Person
public class Employee extends Person {
    public Employee(String name, int id) {
        super(name, id); // Call parent constructor
    }

    // You can add employee-specific fields/methods later
}

