/**   Problem 1: Advanced Student Management (List, Comparator, Map)

 Create a Student class with id, name, age, grade, and branch.
 •	Store at least 15 students in an ArrayList.
 •	Sort students by branch, then by descending grade.
 •	Group students by branch using a Map<String, List<Student>>.
  */

package CollectionAssignments.Ques1StudentManager;

import java.util.*;

/**
 * This class manages student records:
 * - It stores them in a list
 * - Sorts them by branch and then by grade
 * - Groups them by branch
 */
public class StudentManager {
    public static void main(String[] args) {

        // Create a list to store students
        List<Student> students = new ArrayList<>();

        // Let's add 15 student records to our list
        students.add(new Student(101, "Alice", 20, 88.5, "CSE"));
        students.add(new Student(102, "Bob", 21, 77.0, "ECE"));
        students.add(new Student(103, "Charlie", 22, 67.5, "CSE"));
        students.add(new Student(104, "David", 20, 91.0, "EEE"));
        students.add(new Student(105, "Eva", 21, 85.0, "ECE"));
        students.add(new Student(106, "Frank", 22, 73.0, "CSE"));
        students.add(new Student(107, "Grace", 23, 92.0, "EEE"));
        students.add(new Student(108, "Hannah", 21, 89.5, "CSE"));
        students.add(new Student(109, "Ian", 20, 72.0, "ECE"));
        students.add(new Student(110, "Jack", 21, 81.0, "EEE"));
        students.add(new Student(111, "Kira", 22, 78.0, "CSE"));
        students.add(new Student(112, "Leo", 23, 93.5, "EEE"));
        students.add(new Student(113, "Mona", 20, 86.0, "ECE"));
        students.add(new Student(114, "Nina", 21, 79.0, "CSE"));
        students.add(new Student(115, "Oscar", 22, 74.5, "EEE"));

        // ======================================
        // STEP 1: Sort students
        // We'll use our custom Comparator class that sorts:
        // - First by branch (A-Z)
        // - Then by grade (high to low)
        // ======================================
        students.sort(new StudentBranchGradeComparator());

        // Print the sorted list
        System.out.println("Sorted Students (by Branch, then Grade):");
        for (Student s : students) {
            System.out.println(s);  // toString() method in Student class formats this output
        }

        // ======================================
        // STEP 2: Group students by their branch
        // We'll create a Map where:
        // - Key = Branch name like "CSE", "ECE"
        // - Value = List of students from that branch
        // ======================================
        Map<String, List<Student>> groupedByBranch = new HashMap<>();

        for (Student s : students) {
            // Check if branch already exists in the map
            if (!groupedByBranch.containsKey(s.branch)) {
                // If not, add a new empty list for that branch
                groupedByBranch.put(s.branch, new ArrayList<>());
            }

            // Add the student to the list for their branch
            groupedByBranch.get(s.branch).add(s);
        }

        // ======================================
        // STEP 3: Print students branch-wise
        // We'll go through each entry in the map and print the students
        // ======================================
        System.out.println("\nStudents Grouped by Branch:");

        for (String branch : groupedByBranch.keySet()) {
            System.out.println("\nBranch: " + branch);  // Print the branch name

            for (Student s : groupedByBranch.get(branch)) {
                System.out.println(s);  // Print student details for that branch
            }
        }
    }
}

