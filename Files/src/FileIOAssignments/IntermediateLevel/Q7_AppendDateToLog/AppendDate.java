/* 7. Write a program to append the line “Last updated on [current date]” to an existing file log.txt.*/

package FileIOAssignments.IntermediateLevel.Q7_AppendDateToLog;

import java.io.*;
import java.time.LocalDate;

public class AppendDate {
    public static void main(String[] args) {
        File file = new File("src/FileIOAssignments/IntermediateLevel/Q7_AppendDateToLog/log.txt");
        String currentDate = "Last updated on " + LocalDate.now();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.newLine(); // Start on a new line
            writer.write(currentDate);
            System.out.println("Date appended successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

