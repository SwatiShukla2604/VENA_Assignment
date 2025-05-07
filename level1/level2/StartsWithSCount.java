/** Count how many strings in a list start with “S”.*/

package Functional_Programming_Assignment.level1.level2;

import java.util.*;

public class StartsWithSCount {

    public static void main(String[] args) {
        try {
            List<String> names = Arrays.asList("Steve", "Alice", null, "Sam", "bob", "susan", "Sophie", "", "s");

            // Step 1: Check if list is null or empty
            if (names == null || names.isEmpty()) {
                System.out.println("Input list is null or empty.");
                return;
            }

            // Step 2: Count strings starting with 'S' or 's'
            long count = names.stream()
                    .filter(Objects::nonNull)                        // Avoid nulls
                    .map(String::trim)                              // Remove extra spaces
                    .filter(name -> !name.isEmpty())                // Skip empty strings
                    .filter(name -> name.toLowerCase().startsWith("s"))  // Case-insensitive check
                    .count();

            // Step 3: Display result
            System.out.println("Number of names starting with 'S': " + count);

        } catch (Exception e) {
            System.err.println("Error while counting names: " + e.getMessage());
        }
    }
}
