/* 10. Write a program to list all files and directories in a folder called documents.
*/

package FileIOAssignments.IntermediateLevel.Q10_ListFiles;

import java.io.*;

public class ListFiles {
    public static void main(String[] args) {
        File folder = new File("src/FileIOAssignments/IntermediateLevel/Q10_ListFiles/documents");

        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    System.out.println(file.getName());
                }
            }
        } else {
            System.out.println("The directory does not exist or is not a directory.");
        }
    }
}

