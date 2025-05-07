/** From a list of words, create a list of their lengths */

package Functional_Programming_Assignment.level1.level2;

import java.util.*;
import java.util.stream.Collectors;

public class WordLengthList {

    public static void main(String[] args) {
        try {
            // Sample list of words (with some null and empty strings to test edge cases)
            List<String> words = Arrays.asList("Java", "", null, "Streams", "Code");

            // Step 1: Validate input list
            if (words == null || words.isEmpty()) {
                System.out.println("Input list is null or empty.");
                return;
            }

            // Step 2: Process - filter out nulls, then map to lengths
            List<Integer> wordLengths = words.stream()
                    .filter(Objects::nonNull)          // Remove null entries
                    .map(String::length)              // Get length of each word
                    .collect(Collectors.toList());    // Collect to list

            // Step 3: Output
            System.out.println("Lengths of words: " + wordLengths);

        } catch (Exception e) {
            System.err.println("An error occurred while processing word lengths: " + e.getMessage());
        }
    }
}
