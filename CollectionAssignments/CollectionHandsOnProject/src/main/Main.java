package main;

import model.Course;
import model.Student;
import service.RegistrationSystem;

public class Main {
    public static void main(String[] args) {
        RegistrationSystem regSystem = new RegistrationSystem();

        // Sample Students
        regSystem.addStudent(new Student("S101", "Alice", "alice@example.com", 2, "CSE"));
        regSystem.addStudent(new Student("S102", "Bob", "bob@example.com", 3, "ECE"));

        // Sample Courses
        regSystem.addCourse(new Course("CSE101", "Data Structures", "Dr. Smith", 1, 4));
        regSystem.addCourse(new Course("CSE102", "Algorithms", "Dr. John", 2, 3));

        // Registration
        System.out.println(regSystem.registerStudent("S101", "CSE101"));
        System.out.println(regSystem.registerStudent("S102", "CSE101")); // Should be waitlisted
        System.out.println(regSystem.dropStudent("S101", "CSE101"));     // S102 should be promoted
    }
}