/** From a list of words, remove duplicates and return the sorted result.
*/

package Functional_Programming_Assignment.level1.level4;

import java.util.*;
import java.util.stream.Collectors;

// ✅ Question: From a list of words, remove duplicates and return sorted result.

public class RemoveDuplicatesAndSort {

    public static void main(String[] args) {
        // 📝 Sample list of words (with duplicates)
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "kiwi");

        // ✅ Remove duplicates using distinct(), then sort alphabetically, and collect to list
        List<String> uniqueSortedWords = words.stream()
                .distinct()                      // Remove duplicates
                .sorted()                        // Sort alphabetically
                .collect(Collectors.toList());   // Collect to List

        // 🖨️ Print the final result
        System.out.println("Unique Sorted Words: " + uniqueSortedWords);
    }
}
