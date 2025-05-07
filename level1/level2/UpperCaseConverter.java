/** Convert a list of strings to uppercase using map().*/

package Functional_Programming_Assignment.level1.level2;

import java.util.*;
import java.util.stream.Collectors;

public class UpperCaseConverter {

    public static void main(String[] args) {
        try {
            List<String> words = Arrays.asList("hello", null, "world", "java", "", "stream");

            // Step 1: Validate input
            if (words == null || words.isEmpty()) {
                System.out.println("Input list is null or empty.");
                return;
            }

            // Step 2: Convert to uppercase, handle nulls
            List<String> upperWords = words.stream()
                    .filter(Objects::nonNull)          // Skip nulls
                    .map(String::toUpperCase)          // Convert to uppercase
                    .collect(Collectors.toList());

            // Step 3: Output
            if (upperWords.isEmpty()) {
                System.out.println("No valid words to convert.");
            } else {
                System.out.println("Uppercase words: " + upperWords);
            }

        } catch (Exception e) {
            System.err.println("Error during uppercase conversion: " + e.getMessage());
        }
    }
}
