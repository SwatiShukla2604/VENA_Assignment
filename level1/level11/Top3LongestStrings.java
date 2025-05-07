/* Create a program that returns the top 3 longest strings from a list, using streams.*/

package Functional_Programming_Assignment.level1.level11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Top3LongestStrings {
    public static void main(String[] args) {
        // Step 1: Create a sample list of strings
        List<String> words = Arrays.asList(
                "elephant", "cat", "giraffe", "hippopotamus", "dog", "alligator", "ant"
        );

        // Step 2: Use streams to sort by length in descending order, and take top 3
        List<String> top3Longest = words.stream()
                .sorted(Comparator.comparingInt(String::length).reversed()) // sort by length, longest first
                .limit(3) // take only top 3
                .collect(Collectors.toList()); // collect to a list

        // Step 3: Print the result
        System.out.println("Top 3 longest strings:");
        top3Longest.forEach(System.out::println);
    }
}



