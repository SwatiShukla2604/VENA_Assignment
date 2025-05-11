// Q11_CopyImage.java
// Question: Write a program to read a binary file (e.g., image.jpg) and copy its contents to image_copy.jpg.

package FileIOAssignments.AdvanceLevel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Q11_CopyImage {
    public static void main(String[] args) {
        // Source image file (place it in the same folder as this class)
        File sourceFile = new File("src/FileIOAssignments/AdvanceLevel/image.jpg");
        File destFile = new File("src/FileIOAssignments/AdvanceLevel/image_copy.jpg");

        // Use FileInputStream and FileOutputStream for binary data
        try (FileInputStream inputStream = new FileInputStream(sourceFile);
             FileOutputStream outputStream = new FileOutputStream(destFile)) {

            byte[] buffer = new byte[1024]; // buffer to read chunks
            int bytesRead;

            // Read from source and write to destination
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("Image copied successfully to image_copy.jpg");

        } catch (IOException e) {
            System.out.println("Error occurred during file copy: " + e.getMessage());
        }
    }
}
