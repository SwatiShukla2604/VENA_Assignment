// Question: Create a stream pipeline to flatten a list of lists of integers and return the distinct even numbers.

package Functional_Programming_Assignment.level1.level6;

import java.util.*;
import java.util.stream.Collectors;

public class FlattenEvenDistinct {
    public static void main(String[] args) {

        // Sample input: list of lists
        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(2, 4),
                Arrays.asList(5, 6)
        );

        // Step-by-step stream pipeline:
        List<Integer> distinctEvenNumbers = nestedList.stream()                     // Stream<List<Integer>>
                .flatMap(list -> list.stream())                                        // Flatten into Stream<Integer>
                .filter(num -> num % 2 == 0)                                           // Keep only even numbers
                .distinct()                                                            // Remove duplicates
                .collect(Collectors.toList());                                         // Collect into a List

        // Output: [2, 4, 6]
        System.out.println("Distinct Even Numbers: " + distinctEvenNumbers);
    }
}
