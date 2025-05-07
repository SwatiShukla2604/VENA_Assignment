
/*Question: Compute the average length of strings in a list.
*/

package Functional_Programming_Assignment.level1.level4;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class AverageStringLength {

    public static void main(String[] args) {
        // Sample list of strings
        List<String> words = Arrays.asList("hello", "java", "stream", "api");

        // Step 1: Convert each string to its length and calculate the average
        OptionalDouble optionalAverage = words.stream()
                .mapToInt(String::length) // Convert each string to its length
                .average();               // Compute the average

        // Step 2: Handle edge case using OptionalDouble
        if (optionalAverage.isPresent()) {
            double average = optionalAverage.getAsDouble();
            System.out.println("Average string length: " + average);
        } else {
            // Case when the list is empty
            System.out.println("List is empty. Cannot compute average length.");
        }
    }
}
