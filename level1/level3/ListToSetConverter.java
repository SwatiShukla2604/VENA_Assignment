// Question: Convert a list of integers to a Set using Collectors.toSet()

package Functional_Programming_Assignment.level1.level3;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ListToSetConverter {

    public static void main(String[] args) {

        // Step 1: Create a list with some duplicate numbers
        List<Integer> numbers = Arrays.asList(10, 20, 30, 10, 20, 40, 50);

        // Step 2: Convert the list to a Set using stream and Collectors.toSet()
        // This removes any duplicate values automatically
        Set<Integer> uniqueNumbers = numbers.stream()
                .collect(Collectors.toSet());

        // Step 3: Print the Set
        System.out.println("Unique numbers: " + uniqueNumbers);
    }
}

