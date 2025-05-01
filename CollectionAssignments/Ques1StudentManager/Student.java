package CollectionAssignments.Ques1StudentManager;

/**
    Model class to represent each Student
 */
public class Student {
    int id;         // Unique ID for the student
    String name;    // Name of the student
    int age;        // Age of the student
    double grade;   // Grade or marks
    String branch;  // Department or Branch (e.g., CSE, ECE)

    // Constructor to initialize all student properties
    public Student(int id, String name, int age, double grade, String branch) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.branch = branch;
    }

    // toString() is automatically called when we print the object, if we do not override it will print something default
    @Override  //It ensures you’re really overriding a method correctly.
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age +
                ", Grade: " + grade + ", Branch: " + branch;
    }
}
