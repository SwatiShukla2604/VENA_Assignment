/**Chain multiple stream operations: filter > map > sort > collect.*/

package Functional_Programming_Assignment.level1.level4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamChainExample {
    public static void main(String[] args) {
        // Sample input list of names
        List<String> names = Arrays.asList("Alice", "bob", "Andrew", "Angela", "Brian", "adam");

        // Step-by-step stream chaining
        List<String> result = names.stream()

                // Step 1: Filter names starting with "A" or "a"
                .filter(name -> name.toLowerCase().startsWith("a"))

                // Step 2: Convert to uppercase
                .map(String::toUpperCase)

                // Step 3: Sort alphabetically
                .sorted()

                // Step 4: Collect into a List
                .collect(Collectors.toList());

        // Output the final result
        System.out.println("Filtered, Mapped, Sorted Names: " + result);
    }
}

