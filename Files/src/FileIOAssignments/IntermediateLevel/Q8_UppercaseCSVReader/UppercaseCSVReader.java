/* 8. Write a program that reads a CSV file named employees.csv and prints each line in uppercase.*/

package FileIOAssignments.IntermediateLevel.Q8_UppercaseCSVReader;


import java.io.*;

public class UppercaseCSVReader {
    public static void main(String[] args) {
        File file = new File("src/FileIOAssignments/IntermediateLevel/Q8_UppercaseCSVReader/employees.csv");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

