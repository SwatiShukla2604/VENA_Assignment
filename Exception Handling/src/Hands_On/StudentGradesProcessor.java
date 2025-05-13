package Hands_On;

import java.io.*;
import java.util.*;

// Custom Exception for Invalid Grades (out-of-range values)
class InvalidGradeException extends Exception {
    public InvalidGradeException(String message) {
        super(message);
    }
}

public class StudentGradesProcessor {

    public static void main(String[] args) {
        // Accept file path from user at runtime
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter path to grades.txt file: ");
        String fileName = scanner.nextLine();

        // Structures to hold valid data
        List<Integer> validGrades = new ArrayList<>();
        Map<String, Integer> studentGradeMap = new LinkedHashMap<>();
        List<String> failingStudents = new ArrayList<>();
        StringBuilder outputBuilder = new StringBuilder(); // Collect output to write to file
        int totalGrades = 0;

        // Try-with-resources to read the file safely
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            // Read each line of the file
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");

                // Skip lines that don't follow the expected format
                if (parts.length != 2) {
                    String msg = "Skipping invalid entry (wrong format): " + line;
                    System.out.println(msg);
                    outputBuilder.append(msg).append("\n");
                    continue;
                }

                String studentName = parts[0];
                String gradeStr = parts[1];

                try {
                    // Try to convert grade string to an integer
                    int grade = Integer.parseInt(gradeStr);

                    // Throw custom exception if grade is out of valid range
                    if (grade < 0 || grade > 100) {
                        throw new InvalidGradeException("Grade out of range for " + studentName + ": " + grade);
                    }

                    // Store valid grade
                    validGrades.add(grade);
                    studentGradeMap.put(studentName, grade);
                    totalGrades += grade;

                    // Check if student is failing
                    if (grade < 40) {
                        failingStudents.add(studentName);
                    }

                } catch (NumberFormatException e) {
                    String msg = "Invalid number format for " + studentName + ": " + gradeStr;
                    System.out.println(msg);
                    outputBuilder.append(msg).append("\n");
                } catch (InvalidGradeException e) {
                    System.out.println(e.getMessage());
                    outputBuilder.append(e.getMessage()).append("\n");
                }
            }

        } catch (FileNotFoundException e) {
            String msg = "The file was not found: " + fileName;
            System.out.println(msg);
            return;
        } catch (IOException e) {
            String msg = "Error reading the file: " + e.getMessage();
            System.out.println(msg);
            return;
        }

        // Calculate average of valid grades
        double averageGrade = 0.0;
        if (!validGrades.isEmpty()) {
            averageGrade = totalGrades / (double) validGrades.size();
        }

        // Display and collect valid student data
        outputBuilder.append("\nValid Students and their Grades:\n");
        for (Map.Entry<String, Integer> entry : studentGradeMap.entrySet()) {
            String line = entry.getKey() + " : " + entry.getValue();
            System.out.println(line);
            outputBuilder.append(line).append("\n");
        }

        // Display and collect average
        String avgLine = "\nAverage Grade: " + (validGrades.isEmpty() ? "N/A" : averageGrade);
        System.out.println(avgLine);
        outputBuilder.append(avgLine).append("\n");

        // Display and collect failing students
        outputBuilder.append("\nFailing Students (Grade < 40):\n");
        if (failingStudents.isEmpty()) {
            String noFailMsg = "None";
            System.out.println(noFailMsg);
            outputBuilder.append(noFailMsg).append("\n");
        } else {
            for (String name : failingStudents) {
                System.out.println(name);
                outputBuilder.append(name).append("\n");
            }
        }

        // Write results to a file using try-with-resources
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("results.txt"))) {
            writer.write(outputBuilder.toString());
            System.out.println("\nResults have been written to results.txt successfully.");
        } catch (IOException e) {
            System.out.println("Failed to write results to file: " + e.getMessage());
        }
    }
}
