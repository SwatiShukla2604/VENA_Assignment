// Q12_MergeTextFiles.java
// Question: Write a program that reads all .txt files in a folder and merges their contents into a single file named merged.txt

package FileIOAssignments.AdvanceLevel;

import java.io.*;

public class Q12_MergeTextFiles {
    public static void main(String[] args) {
        // Folder that contains the .txt files
        File folder = new File("src/FileIOAssignments/AdvanceLevel/texts");

        // Output file
        File outputFile = new File("src/FileIOAssignments/AdvanceLevel/merged.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            // Get all files from the folder
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    // Process only .txt files
                    if (file.isFile() && file.getName().endsWith(".txt")) {
                        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                            String line;
                            // Read each line and write to output
                            while ((line = reader.readLine()) != null) {
                                writer.write(line);
                                writer.newLine();
                            }
                            writer.newLine(); // Add an extra line between files
                        }
                    }
                }
                System.out.println("All text files have been merged into merged.txt");
            } else {
                System.out.println("Folder is empty or does not exist.");
            }
        } catch (IOException e) {
            System.out.println("Error while merging files: " + e.getMessage());
        }
    }
}
