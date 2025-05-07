/**Write a function that takes a list of strings and returns a map of word to its length.*/

package Functional_Programming_Assignment.level1.level4;

import java.util.*;
import java.util.stream.Collectors;

public class Q1WordLengthMap {

    public static void main(String[] args) {
        // Input list of words
        List<String> words = Arrays.asList("apple", "banana", "cherry", "", null);

        // Create a map of word -> length using stream
        Map<String, Integer> wordLengthMap = words.stream()
                .filter(Objects::nonNull) // ❗ handle null entries
                .collect(Collectors.toMap(
                        word -> word,
                        word -> word.length(),
                        (oldValue, newValue) -> oldValue // ❗ handle duplicates if any
                ));

        // Output the result
        System.out.println("Map of word to its length: " + wordLengthMap);
    }
}
