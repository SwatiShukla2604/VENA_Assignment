/** Find the longest string in a list using reduce().*/

package Functional_Programming_Assignment.level1.level2;

import java.util.*;

public class LongestStringFinder {

    public static void main(String[] args) {
        try {
            List<String> words = Arrays.asList("apple", null, "banana", "strawberry", "", "kiwi", "pineapple", "mango");

            // Step 1: Check for null or empty list
            if (words == null || words.isEmpty()) {
                System.out.println("Input list is null or empty.");
                return;
            }

            // Step 2: Use stream to find longest string using reduce()
            Optional<String> longest = words.stream()
                    .filter(Objects::nonNull)      // Remove nulls
                    .filter(s -> !s.trim().isEmpty()) // Remove blank or empty strings
                    .reduce((s1, s2) -> s1.length() >= s2.length() ? s1 : s2);

            // Step 3: Print result using Optional
            if (longest.isPresent()) {
                System.out.println("Longest string: " + longest.get());
            } else {
                System.out.println("No valid strings found in the list.");
            }

        } catch (Exception e) {
            System.err.println("An error occurred while finding the longest string: " + e.getMessage());
        }
    }
}
