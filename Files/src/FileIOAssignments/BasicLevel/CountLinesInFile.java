package FileIOAssignments.BasicLevel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * Question 4:
 * Write a program to count the number of lines in a text file called data.txt.
 */

public class CountLinesInFile {
    public static void main(String[] args) {
        // File to read from
        String fileName = "data.txt";
        int lineCount = 0;

        // Try-with-resources for auto-closing reader
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            // Read line by line
            while (reader.readLine() != null) {
                lineCount++;
            }

            System.out.println("Total number of lines in " + fileName + ": " + lineCount);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
