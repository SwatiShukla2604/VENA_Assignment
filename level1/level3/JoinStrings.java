/** Join a list of strings into a single comma-separated string.*/

package Functional_Programming_Assignment.level1.level3;

import java.util.*;
import java.util.stream.Collectors;

public class JoinStrings {

    // Method to join list of strings into a single comma-separated string
    public static String joinWords(List<String> words) {

        // Check for null or empty list
        if (words == null || words.isEmpty()) {
            System.out.println("List is null or empty. Returning empty string.");
            return "";
        }

        // Use Stream API to filter out nulls and join with ", "
        return words.stream()
                .filter(Objects::nonNull) // Skip null values
                .collect(Collectors.joining(", ")); // Join words with comma and space
    }

    public static void main(String[] args) {
        // Sample input list
        List<String> input = Arrays.asList("Java", "Python", null, "C++");

        // Try to join the strings
        try {
            String result = joinWords(input);
            System.out.println("Joined String: " + result); // Output: Java, Python, C++
        } catch (Exception e) {
            System.out.println("Error while joining strings: " + e.getMessage());
        }
    }
}
