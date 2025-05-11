// Question 14:
// Write a program that uses NIO (Files class) to read and write data between files with proper exception handling.

package FileIOAssignments.AdvanceLevel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileCopyUsingNIO {

    public static void main(String[] args) {
        // Define the source and destination file paths
        Path sourcePath = Paths.get("source.txt");
        Path destinationPath = Paths.get("destination.txt");

        // Using try-catch for proper exception handling
        try {
            // Read the content from the source file
            String content = new String(Files.readAllBytes(sourcePath));

            // Write the content to the destination file
            Files.write(destinationPath, content.getBytes());

            System.out.println("File content has been successfully copied.");

        } catch (IOException e) {
            // Handle any IOExceptions (file not found, permissions issues, etc.)
            System.err.println("An error occurred during file operations: " + e.getMessage());
        }
    }
}

