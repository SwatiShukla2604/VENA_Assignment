/**  Problem 2: Unique Word Frequency Counter (Map, TreeSet)
 Given a paragraph, calculate and print:
 •	Number of unique words
 •	Frequency of each word
 •	Display words sorted alphabetically
 */

package CollectionAssignments.Ques2UniqueWordFreqCounter;

import java.util.*;

/**
 * This class counts the number of unique words in a paragraph
 * and displays their frequency in alphabetical order.
 */
public class UniqueWordFrequencyCounter {

    public static void main(String[] args) {
        try {
            // Scanner is used to take input from the user
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter a paragraph:");
            String paragraph = scanner.nextLine();

            // Edge Case: If input is null or only spaces, exit the program
            if (paragraph == null || paragraph.trim().isEmpty()) {
                System.out.println("Paragraph is empty. No words to count.");
                return;
            }

            // Convert all characters to lowercase so that "Java" and "java" are treated the same
            paragraph = paragraph.toLowerCase();

            // Why we use this line: paragraph.replaceAll("[^a-z0-9\\s]", "")
            // This removes all characters that are NOT:
            // - lowercase letters a-z
            // - digits 0-9
            // - whitespace characters (like spaces, tabs)
            //
            // The regex [^a-z0-9\\s] means:
            // ^   → not
            // a-z → lowercase letters
            // 0-9 → numbers
            // \\s → whitespace (space, tab, newline etc.)
            //
            // So we're keeping only words and spaces and removing punctuation like . , ! ? etc.
            paragraph = paragraph.replaceAll("[^a-z0-9\\s]", "");

            // Split paragraph by one or more spaces using regex \\s+
            String[] words = paragraph.trim().split("\\s+");

            // Create a map to store word frequency
            Map<String, Integer> wordFrequencyMap = new HashMap<>();

            for (String word : words) {

                // Why we check word.isEmpty()
                // Even after splitting by \\s+, sometimes empty strings may appear.
                // This happens if the input has weird spacing or trailing punctuation.
                // This check avoids processing "" as a word.
                if (word.isEmpty()) continue;

                // Replacing getOrDefault with beginner-friendly version
                // This is easier to understand for beginners compared to:
                // wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
                if (wordFrequencyMap.containsKey(word)) {
                    // Word already exists, so increment its count
                    wordFrequencyMap.put(word, wordFrequencyMap.get(word) + 1);
                } else {
                    // Word appears for the first time, set count to 1
                    wordFrequencyMap.put(word, 1);
                }
            }

            // TreeSet automatically sorts keys (words) in alphabetical order
            Set<String> sortedWords = new TreeSet<>(wordFrequencyMap.keySet());

            // Output the total number of unique words
            System.out.println("\nTotal Unique Words: " + sortedWords.size());

            // Output word frequencies in alphabetical order
            System.out.println("\nWord Frequencies (Alphabetical Order):");
            for (String word : sortedWords) {
                System.out.println(word + ": " + wordFrequencyMap.get(word));
            }

        } catch (Exception e) {
            // Why we use e.getMessage()
            // This gives a short and user-friendly description of what went wrong
            // Instead of crashing the program or showing a long technical error
            System.out.println("An error occurred while processing input: " + e.getMessage());

            // For developers, we can also print the full stack trace using:
            // e.printStackTrace(); // Uncomment this line during debugging
        }
    }
}


