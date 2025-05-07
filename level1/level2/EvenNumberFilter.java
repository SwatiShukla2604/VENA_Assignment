/** Filter a list of integers to only even numbers.*/

package Functional_Programming_Assignment.level1.level2;

import java.util.*;
import java.util.stream.Collectors;

public class EvenNumberFilter {

    public static void main(String[] args) {
        try {
            List<Integer> numbers = Arrays.asList(1, 2, null, 4, 5, 6, 7, 8, null);

            // Step 1: Handle null or empty list
            if (numbers == null || numbers.isEmpty()) {
                System.out.println("Input list is null or empty.");
                return;
            }

            // Step 2: Filter even numbers, safely skip nulls
            List<Integer> evenNumbers = numbers.stream()
                    .filter(Objects::nonNull)        // Avoid NullPointerException
                    .filter(n -> n % 2 == 0)         // Keep only even numbers
                    .collect(Collectors.toList());

            // Step 3: Print result
            if (evenNumbers.isEmpty()) {
                System.out.println("No even numbers found.");
            } else {
                System.out.println("Even numbers: " + evenNumbers);
            }

        } catch (Exception e) {
            System.err.println("Error while filtering even numbers: " + e.getMessage());
        }
    }
}
