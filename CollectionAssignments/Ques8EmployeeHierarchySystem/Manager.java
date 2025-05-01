package CollectionAssignments.Ques8EmployeeHierarchySystem;

// Manager is also a type of Person
public class Manager extends Person {
    public Manager(String name, int id) {
        super(name, id); // Call parent constructor
    }

    // You can add manager-specific fields/methods later
}

