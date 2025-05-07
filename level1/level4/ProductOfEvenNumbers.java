/*Find the product of all even numbers in a list using reduce().*/


package Functional_Programming_Assignment.level1.level4;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProductOfEvenNumbers {

    public static void main(String[] args) {
        // Sample list of integers
        List<Integer> numbers = Arrays.asList(2, 3, 4, 6, 7, 8);

        // Step 1: Filter even numbers, then reduce to product
        Optional<Integer> productOptional = numbers.stream()
                .filter(n -> n % 2 == 0)     // Keep only even numbers
                .reduce((a, b) -> a * b);   // Multiply all remaining elements

        // Step 2: Handle empty result safely
        if (productOptional.isPresent()) {
            System.out.println("Product of even numbers: " + productOptional.get());
        } else {
            // Case when there are no even numbers
            System.out.println("No even numbers found. Product cannot be calculated.");
        }
    }
}
