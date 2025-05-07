/**Partition a list of integers into even and odd using Collectors.partitioningBy().*/

package Functional_Programming_Assignment.level1.level3;

import java.util.*;
import java.util.stream.Collectors;

public class PartitionEvenOdd {

    // Method to divide numbers into even and odd groups
    public static Map<Boolean, List<Integer>> partitionEvenAndOdd(List<Integer> numbers) {

        // Check if list is null or empty
        if (numbers == null || numbers.isEmpty()) {
            System.out.println("List is null or empty. Returning empty map.");
            return Collections.emptyMap();
        }

        // Use Stream API to filter out nulls and then partition into even and odd
        return numbers.stream()
                .filter(Objects::nonNull) // remove null values from the list
                .collect(Collectors.partitioningBy(num -> num % 2 == 0)); // true if even, false if odd
    }

    public static void main(String[] args) {
        // Sample input list
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6, null);

        // Try to partition list, catch any unexpected errors
        try {
            Map<Boolean, List<Integer>> result = partitionEvenAndOdd(input);

            // Print results
            System.out.println("Even numbers: " + result.get(true));
            System.out.println("Odd numbers : " + result.get(false));

        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
