/** Given a list of names, return a list of names longer than 4 characters.*/

package Functional_Programming_Assignment.level1.level2;

import java.util.*;
import java.util.stream.Collectors;

public class NameLengthFilter {

    public static void main(String[] args) {
        try {
            // Step 1: Prepare input (including edge case with null/empty values)
            List<String> names = Arrays.asList("John", "Alice", null, "Bob", "Samantha", "Tom", "");

            // Step 2: Check if list is null or empty
            if (names == null || names.isEmpty()) {
                System.out.println("Input list is empty or null. No names to process.");
                return;
            }

            // Step 3: Use stream to filter names longer than 4 characters (excluding nulls)
            List<String> longNames = names.stream()
                    .filter(Objects::nonNull)                // Remove null values safely
                    .filter(name -> name.length() > 4)       // Keep only names with length > 4
                    .collect(Collectors.toList());           // Collect to a new list

            // Step 4: Display result
            if (longNames.isEmpty()) {
                System.out.println("No names found longer than 4 characters.");
            } else {
                System.out.println("Names longer than 4 characters: " + longNames);
            }

        } catch (Exception e) {
            System.err.println("An error occurred while filtering names: " + e.getMessage());
            e.printStackTrace(); // For debugging
        }
    }
}
