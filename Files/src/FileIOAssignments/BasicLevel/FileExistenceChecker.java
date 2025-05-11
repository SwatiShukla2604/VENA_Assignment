package FileIOAssignments.BasicLevel;

import java.io.File;

/*
 * Question 3:
 * Write a program that checks if a file named report.pdf exists in the current directory
 * and prints its size (in bytes).
 */

public class FileExistenceChecker {
    public static void main(String[] args) {
        // Create a File object pointing to report.pdf
        File file = new File("report.pdf");

        // Check if the file exists
        if (file.exists()) {
            System.out.println("File exists: " + file.getName());
            System.out.println("Size: " + file.length() + " bytes");
        } else {
            System.out.println("File 'report.pdf' does not exist in the current directory.");
        }

        File file1 = new File("notes.txt");

        // Check if the file exists
        if (file1.exists()) {
            System.out.println("File exists: " + file1.getName());
            System.out.println("Size: " + file1.length() + " bytes");
        } else {
            System.out.println("File 'notes.txt' does not exist in the current directory.");
        }
    }
}
