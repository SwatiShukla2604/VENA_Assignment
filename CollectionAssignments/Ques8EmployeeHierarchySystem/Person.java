package CollectionAssignments.Ques8EmployeeHierarchySystem;

import java.util.Objects;

// Common superclass for Employee and Manager
public class Person {
    protected String name;
    protected int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for ID
    public int getId() {
        return id;
    }

    // equals() to check if two persons are the same (based on name and id)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person other = (Person) o;
        return id == other.id && Objects.equals(name, other.name);
    }

    // hashCode to avoid duplicates in hash-based collections
    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    // String representation of the object
    @Override
    public String toString() {
        return name + " (ID: " + id + ")";
    }
}

