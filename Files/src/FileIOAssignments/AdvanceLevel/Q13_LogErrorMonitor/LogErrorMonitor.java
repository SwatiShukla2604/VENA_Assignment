// Q13_LogErrorMonitor/LogErrorMonitor.java
package FileIOAssignments.AdvanceLevel.Q13_LogErrorMonitor;

import java.io.*;

/**
 * Q13: Write a program that monitors a log file (server.log)
 * and prints only the lines that contain the word "ERROR".
 */

public class LogErrorMonitor {
    public static void main(String[] args) {
        // Path to the server log file
        File logFile = new File("src/FileIOAssignments/AdvanceLevel/Q13_LogErrorMonitor/server.log");

        // Use BufferedReader to read the file efficiently
        try (BufferedReader reader = new BufferedReader(new FileReader(logFile))) {
            String line;

            System.out.println("Lines with ERROR:");
            while ((line = reader.readLine()) != null) {
                // Check if the line contains "ERROR"
                if (line.contains("ERROR")) {
                    System.out.println(line);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Log file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading the log file: " + e.getMessage());
        }
    }
}
