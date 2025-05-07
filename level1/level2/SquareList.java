/** Convert a list of integers into a list of their squares*/

package Functional_Programming_Assignment.level1.level2;

import java.util.*;
import java.util.stream.Collectors;

public class SquareList {

    public static void main(String[] args) {
        try {
            // Sample list with some null values to test edge case handling
            List<Integer> numbers = Arrays.asList(2, 3, null, 5, -4, 0, null);

            // Step 1: Validate input list
            if (numbers == null || numbers.isEmpty()) {
                System.out.println("Input list is null or empty.");
                return;
            }

            // Step 2: Process - filter nulls and map to squares
            List<Integer> squaredList = numbers.stream()
                    .filter(Objects::nonNull)         // Remove nulls
                    .map(num -> num * num)            // Square each number
                    .collect(Collectors.toList());    // Collect results

            // Step 3: Output result
            System.out.println("Squared List: " + squaredList);

        } catch (Exception e) {
            System.err.println("An error occurred while squaring the list: " + e.getMessage());
        }
    }
}
