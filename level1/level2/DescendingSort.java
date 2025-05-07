/** Sort a list of integers in descending order using streams.*/

package Functional_Programming_Assignment.level1.level2;

import java.util.*;
import java.util.stream.Collectors;

public class DescendingSort {

    public static void main(String[] args) {
        try {
            List<Integer> numbers = Arrays.asList(10, 4, null, 25, 7, 0, -5, 13, null);

            // Step 1: Validate input
            if (numbers == null || numbers.isEmpty()) {
                System.out.println("Input list is null or empty.");
                return;
            }

            // Step 2: Remove nulls and sort in descending order
            List<Integer> sortedDesc = numbers.stream()
                    .filter(Objects::nonNull)                          // Remove nulls
                    .sorted(Comparator.reverseOrder())                // Sort in descending order
                    .collect(Collectors.toList());                    // Collect to new list

            // Step 3: Output result
            System.out.println("Sorted (Descending): " + sortedDesc);

        } catch (Exception e) {
            System.err.println("An error occurred while sorting: " + e.getMessage());
        }
    }
}
