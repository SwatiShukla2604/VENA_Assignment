// Create notes.txt and write: "This is my first file in Java."

package FileIOAssignments.BasicLevel;

import java.io.FileWriter;
import java.io.IOException;

public class CreateTextFile {
    public static void main(String[] args) {
        // File name to be created
        String fileName = "notes.txt";

        // Content to write in the file
        String content = "This is my first file in Java.";

        // Try-with-resources ensures the file is closed automatically
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content); // Write the content
            System.out.println("File '" + fileName + "' created and written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace(); // Show the detailed error
        }
    }
}
