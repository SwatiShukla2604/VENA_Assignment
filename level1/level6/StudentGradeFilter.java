// From a list of students with names and grades,
// return a list of names of students who scored above 80,
// sorted alphabetically.

package Functional_Programming_Assignment.level1.level6;

import java.util.*;
import java.util.stream.Collectors;

// Class to represent a Student with name and grade
class Student {
    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }
}

public class StudentGradeFilter {
    public static void main(String[] args) {
        // Sample list of students
        List<Student> students = Arrays.asList(
                new Student("Alice", 90),
                new Student("Bob", 75),
                new Student("Charlie", 85),
                new Student("David", 60),
                new Student("Eva", 95),
                new Student("Frank", 82)
        );

        // Filter students with grade > 80, map to names, sort alphabetically, and collect to a list
        List<String> topStudents = students.stream()
                .filter(student -> student.getGrade() > 80) // keep only students with grade > 80
                .map(Student::getName) // convert Student objects to just names
                .sorted() // sort names alphabetically
                .collect(Collectors.toList()); // collect the result into a List

        // Print the result
        System.out.println("Top students (grade > 80): " + topStudents);
    }
}
