// Implement a text analyzer:
// Given a paragraph, split into words, count frequency of each word, and return a map.

package Functional_Programming_Assignment.level1.level11;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TextAnalyzer {
    public static void main(String[] args) {
        // Sample paragraph
        String paragraph = "Java is great. Java is powerful. Streams are powerful tools in Java.";

        // Step 1: Convert paragraph to lowercase and remove punctuation
        String cleaned = paragraph.toLowerCase().replaceAll("[^a-z\\s]", "");

        // Step 2: Split into words using whitespace
        String[] words = cleaned.split("\\s+");

        // Step 3: Count frequency of each word using streams
        Map<String, Long> wordFrequency = Arrays.stream(words)           // Convert array to stream
                .filter(word -> !word.isBlank())                         // Remove empty strings
                .collect(Collectors.groupingBy(                          // Group by word
                        Function.identity(),                             // Use the word itself as key
                        Collectors.counting()                            // Count occurrences
                ));

        // Step 4: Print the resulting word frequency map
        wordFrequency.forEach((word, count) ->
                System.out.println(word + " => " + count));
    }
}
