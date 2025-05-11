package FileIOAssignments.BasicLevel.Q5_CopyFile;

import java.io.*;

/*
5. Write a program that copies the contents of source.txt to a new file called backup.txt.
*/

public class CopyFile {
    public static void main(String[] args) {
        File sourceFile = new File("src/FileIOAssignments/BasicLevel/Q5_CopyFile/source.txt");
        File backupFile = new File("src/FileIOAssignments/BasicLevel/Q5_CopyFile/backup.txt");

        // Try-with-resources ensures files are automatically closed
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(backupFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // preserve line breaks
            }

            System.out.println("File copied successfully to backup.txt");

        } catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading or writing file: " + e.getMessage());
        }
    }
}
