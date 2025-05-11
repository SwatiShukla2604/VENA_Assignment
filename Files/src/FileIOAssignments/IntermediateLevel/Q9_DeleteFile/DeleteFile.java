/* 9. Write a program to delete a file named oldfile.txt if it exists.*/

package FileIOAssignments.IntermediateLevel.Q9_DeleteFile;

import java.io.*;

public class DeleteFile {
    public static void main(String[] args) {
        File file = new File("src/FileIOAssignments/IntermediateLevel/Q9_DeleteFile/oldfile.txt");

        if (file.exists()) {
            if (file.delete()) {
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("Failed to delete the file.");
            }
        } else {
            System.out.println("File does not exist.");
        }
    }
}

