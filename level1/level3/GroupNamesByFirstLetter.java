/** Group a list of names by their first letter using Collectors.groupingBy()*/

package Functional_Programming_Assignment.level1.level3;

import java.util.*;
import java.util.stream.Collectors;

public class GroupNamesByFirstLetter {

    public static Map<Character, List<String>> groupByFirstLetter(List<String> names) {
        if (names == null || names.isEmpty()) {
            System.out.println("Input list is empty or null. Returning empty map.");
            return Collections.emptyMap();
        }

        return names.stream()
                .filter(Objects::nonNull)  // Skip null names
                .filter(name -> !name.trim().isEmpty()) // Skip blank/empty strings
                .collect(Collectors.groupingBy(
                        name -> Character.toUpperCase(name.charAt(0)) // group by first letter (uppercased)
                ));
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", null, "  ", "Ankit", "bobby", "Arjun");

        try {
            Map<Character, List<String>> grouped = groupByFirstLetter(names);
            System.out.println("Grouped by first letter: " + grouped);
        } catch (Exception e) {
            System.err.println("Error occurred during grouping: " + e.getMessage());
        }
    }
}

