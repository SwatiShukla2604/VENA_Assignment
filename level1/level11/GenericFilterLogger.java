// Create a reusable method that filters a list based on a passed-in Predicate<T>
// and logs each filtered item.


package Functional_Programming_Assignment.level1.level11;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GenericFilterLogger {

    public static void main(String[] args) {
        // Example: Filter names that start with "A"
        List<String> names = List.of("Alice", "Bob", "Alex", "Charlie");

        List<String> result = filterAndLog(names, name -> name.startsWith("A"));
        System.out.println("Filtered Result: " + result);
    }

    // ✅ Reusable generic method that filters and logs items
    public static <T> List<T> filterAndLog(List<T> list, Predicate<T> condition) {
        return list.stream()
                .filter(condition)                         // Apply given condition
                .peek(item -> System.out.println("Matched: " + item)) // Log filtered items
                .collect(Collectors.toList());             // Collect into a list
    }
}
