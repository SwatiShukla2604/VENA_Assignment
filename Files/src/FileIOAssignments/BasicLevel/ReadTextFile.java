package FileIOAssignments.BasicLevel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * Question 2:
 * Write a program to read and print the contents of a file named notes.txt.
 */

public class ReadTextFile {
    public static void main(String[] args) {
        // Name of the file to read
        String fileName = "notes.txt";

        // Try-with-resources for safe file handling
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            System.out.println("Contents of " + fileName + ":");

            // Read and print each line until end of file
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace(); // Print detailed error info
        }
    }
}
