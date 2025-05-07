
// Question: Convert a CSV string of numbers ("1,2,3,4") into a List<Integer> using streams and lambdas.

package Functional_Programming_Assignment.level1.level7;

import java.util.*;
import java.util.stream.Collectors;

public class CsvToIntegerList {

    public static void main(String[] args) {
        String csv = "1,2,3,4,5,6,7";

        // Split by comma, stream the array, convert each to Integer, collect as List
        List<Integer> numbers = Arrays.stream(csv.split(","))
                .map(String::trim)          // Remove spaces if any
                .map(Integer::parseInt)     // Convert each string to integer
                .collect(Collectors.toList()); // Collect into a list

        // Print result
        System.out.println("List of Integers: " + numbers);
    }
}
