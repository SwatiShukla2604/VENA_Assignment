/** College Subject Allotment (Map<String, List<String>>)
 •	Store which subjects are allotted to each student
 •	Provide reverse lookup: which students chose a specific subject
  */

package CollectionAssignments.Ques15CollegeSubjectAllotment;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        CollegeSubjectAllotment allotmentSystem = new CollegeSubjectAllotment();

        // Create subject lists for students
        List<String> aliceSubjects = Arrays.asList("Math", "Physics", "Chemistry");
        List<String> bobSubjects = Arrays.asList("Biology", "Math");
        List<String> charlieSubjects = Arrays.asList("History", "Economics");

        // Allot subjects to students
        allotmentSystem.allotSubjectsToStudent("Alice", aliceSubjects);
        allotmentSystem.allotSubjectsToStudent("Bob", bobSubjects);
        allotmentSystem.allotSubjectsToStudent("Charlie", charlieSubjects);
        allotmentSystem.allotSubjectsToStudent(null, null); // Invalid input test

        // Display all student-subject allotments
        allotmentSystem.displayAllAllotments();

        // Reverse lookup: Find students who chose "Math"
        String subjectToSearch = "Math";
        List<String> studentsWithSubject = allotmentSystem.getStudentsBySubject(subjectToSearch);

        System.out.println("\n--- Students who chose subject: " + subjectToSearch + " ---");
        if (studentsWithSubject.isEmpty()) {
            System.out.println("No students found for subject: " + subjectToSearch);
        } else {
            for (String student : studentsWithSubject) {
                System.out.println(student);
            }
        }
    }
}

