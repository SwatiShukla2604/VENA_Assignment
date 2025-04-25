/* 6 Student Registry (Static vs Instance) Create a Student class with a static counter to track total students. Each student has a unique ID and name. Display the total number of students after creating multiple objects. */
// Main.java
class Student {
    private static int studentCount = 0;
    private int id;
    private String name;

    public Student(String name) {
        studentCount++;
        this.id = studentCount;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static int getTotalStudents() {
        return studentCount;
    }

    public void displayInfo() {
        System.out.println("Student ID: " + id + ", Name: " + name);
    }
}

// Change public class name to Main if you're using Main.java
public class StudentRegistry {
    public static void main(String[] args) {
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");
        Student s3 = new Student("Charlie");

        s1.displayInfo();
        s2.displayInfo();
        s3.displayInfo();

        System.out.println("Total students created: " + Student.getTotalStudents());
    }
}
