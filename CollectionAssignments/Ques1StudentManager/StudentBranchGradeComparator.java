package CollectionAssignments.Ques1StudentManager;

import java.util.Comparator;

/**
 * This comparator is used to sort Student objects:
 * 1. First by their branch name (A to Z order)
 * 2. If the branch is the same, then by grade in descending order (higher grade first)
 */
public class StudentBranchGradeComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {

        // Step 1: Compare branch names alphabetically
        int branchCompare = s1.branch.compareTo(s2.branch);
        // Example:
        // s1: EC - grade 90
        // s2: EC - grade 91
        // s3: CS - grade 89
        // EC vs EC → returns 0 (same)
        // EC vs CS → returns > 0 (since 'E' > 'C')

        // Step 2: If branches are same, compare grades in descending order
        if (branchCompare == 0) {
            return Double.compare(s2.grade, s1.grade);
            // Example:
            // EC - 91 vs EC - 90 → returns -1 → s2 (91) comes before s1 (90)
        }

        // Step 3: If branches are different, use the branch order
        return branchCompare;
        // Example:
        // CS - 89 vs EC - 91 → returns negative → CS comes before EC
    }
}


