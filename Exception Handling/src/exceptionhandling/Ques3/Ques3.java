package exceptionhandling.Ques3;

import java.io.*;

/**
 * Question 3: Exception-safe resource handling with multiple resources
 *
 * Write a program that opens two files (BufferedReader and BufferedWriter),
 * reads from one, and writes to the other.
 * Use try-with-resources to ensure both are closed safely, even if exceptions occur in the middle.
 */

public class Ques3{

    public static void main(String[] args) {
        // File paths - You can change these to actual file locations
        String sourceFilePath = "input.txt";     // Source file to read from
        String destinationFilePath = "output.txt"; // Destination file to write to

        // Use try-with-resources to handle both resources safely
        try (
                // BufferedReader to read from the source file
                BufferedReader reader = new BufferedReader(new FileReader(sourceFilePath));
                // BufferedWriter to write to the destination file
                BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFilePath))
        ) {
            String line;

            // Read each line from source and write to destination
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // Preserve line breaks
            }

            System.out.println("File copied successfully.");

        } catch (IOException e) {
            // Catch and log any IOException (file not found, permission denied, etc.)
            System.err.println("Error during file operation: " + e.getMessage());
            e.printStackTrace(); // Optional: for debugging
        }
    }
}
