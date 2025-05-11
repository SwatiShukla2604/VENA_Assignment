/* To write a program that reads a text file, counts the frequency of each character (including spaces and punctuation), and then writes the result to a file named charcount.txt*/

package FileIOAssignments.AdvanceLevel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CharCount {

    public static void main(String[] args) {
        // Specify the input and output files
        String inputFile = "notes.txt";
        String outputFile = "charcount.txt";

        // Create a map to store the frequency of each character
        Map<Character, Integer> charFrequencyMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            // Read the file line by line
            String line;
            while ((line = reader.readLine()) != null) {
                // For each character in the line
                for (char c : line.toCharArray()) {
                    // Update the frequency in the map
                    charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0) + 1);
                }
            }

            // Write the result to the output file
            try (FileWriter writer = new FileWriter(outputFile)) {
                for (Map.Entry<Character, Integer> entry : charFrequencyMap.entrySet()) {
                    writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
                }
            }

            System.out.println("Character frequencies have been written to " + outputFile);

        } catch (IOException e) {
            // Handle file reading/writing exceptions
            System.err.println("An error occurred while reading or writing files: " + e.getMessage());
        }
    }
}
