/* 6. Write a program to read all the words from paragraph.txt and count how many times the word "Java" appears.
*/

package FileIOAssignments.IntermediateLevel.Q6_CountJavaOccurrences;

import java.io.*;
import java.util.*;

public class CountJava {
    public static void main(String[] args) {
        File file = new File("src/FileIOAssignments/IntermediateLevel/Q6_CountJavaOccurrences/paragraph.txt");
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\W+"); // Split by non-word characters
                for (String word : words) {
                    if ("java".equalsIgnoreCase(word)) { // Case-insensitive comparison
                        count++;
                    }
                }
            }
            System.out.println("The word 'Java' appears " + count + " times.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


