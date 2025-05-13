package Files_Hands_On;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //  1. Accept input and output file names from user at runtime
        System.out.print("Enter path to input log file (e.g., server.log): ");
        String inputFile = scanner.nextLine();

        System.out.print("Enter name of output file to write summary (e.g., summary.txt): ");
        String outputFile = scanner.nextLine();

        int totalLines = 0;
        int errorCount = 0;
        int warningCount = 0;

        StringBuilder outputBuilder = new StringBuilder(); //  To store final report content

        //  2. Try-with-resources block to safely read the input file
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;

            while ((line = reader.readLine()) != null) {
                totalLines++; // Count each line as a log entry

                //  Count lines with "ERROR" and "WARNING"
                if (line.contains("ERROR")) {
                    errorCount++;
                }
                if (line.contains("WARNING")) {
                    warningCount++;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("The file was not found: " + inputFile);
            return; // Exit if input file doesn't exist
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return; // Exit if file read fails
        }

        //  3. Calculate percentage for bonus requirement
        double errorPercentage = totalLines > 0 ? (errorCount * 100.0) / totalLines : 0.0;
        double warningPercentage = totalLines > 0 ? (warningCount * 100.0) / totalLines : 0.0;

        //  4. Build output content using StringBuilder
        outputBuilder.append("Log Summary Report\n");
        outputBuilder.append("-------------------\n");
        outputBuilder.append("Total log entries: ").append(totalLines).append("\n");
        outputBuilder.append("ERROR entries: ").append(errorCount)
                .append(" (").append(String.format("%.2f", errorPercentage)).append("%)\n");
        outputBuilder.append("WARNING entries: ").append(warningCount)
                .append(" (").append(String.format("%.2f", warningPercentage)).append("%)\n");

        //  5. Write the summary to output file using try-with-resources
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(outputBuilder.toString());
            System.out.println("\nSummary written to " + outputFile + " successfully.");
        } catch (IOException e) {
            System.out.println("Failed to write summary to file: " + e.getMessage());
        }
    }
}
