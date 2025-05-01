package CollectionAssignments.Ques15CollegeSubjectAllotment;

import java.util.*;

public class CollegeSubjectAllotment {
    private Map<String, List<String>> studentSubjectMap;

    public CollegeSubjectAllotment() {
        studentSubjectMap = new HashMap<>();
    }

    // Method to allot subjects to a student
    public void allotSubjectsToStudent(String studentName, List<String> subjects) {
        if (studentName == null || subjects == null || subjects.isEmpty()) {
            System.out.println("Invalid input. Student or subjects missing.");
            return;
        }

        studentSubjectMap.put(studentName, new ArrayList<>(subjects));
        System.out.println("Subjects allotted to " + studentName + ": " + subjects);
    }

    // Method to display all allotments
    public void displayAllAllotments() {
        System.out.println("\n--- Student Allotments ---");
        if (studentSubjectMap.isEmpty()) {
            System.out.println("No allotments found.");
            return;
        }

        for (Map.Entry<String, List<String>> entry : studentSubjectMap.entrySet()) {
            System.out.println("Student: " + entry.getKey() + ", Subjects: " + entry.getValue());
        }
    }

    // Reverse lookup: Get list of students who selected a specific subject
    public List<String> getStudentsBySubject(String subject) {
        List<String> students = new ArrayList<>();

        if (subject == null || subject.isEmpty()) {
            System.out.println("Invalid subject input.");
            return students;
        }

        // Loop over each student and their subject list
        for (Map.Entry<String, List<String>> entry : studentSubjectMap.entrySet()) {
            String student = entry.getKey();
            List<String> subjects = entry.getValue();

            // Check if current student has this subject
            if (subjects.contains(subject)) {
                students.add(student);
            }
        }

        return students;
    }
}

