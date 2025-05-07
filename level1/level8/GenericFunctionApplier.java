// Question 3: Write a generic method that accepts a List<T> and a Function<T, R>
// and applies the function to all elements.

package Functional_Programming_Assignment.level1.level8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GenericFunctionApplier {

    // Generic method: accepts any type of list and a function, applies function to each item
    public static <T, R> List<R> applyFunction(List<T> inputList, Function<T, R> transformer) {
        return inputList.stream()
                .map(transformer)  // Apply function to each item
                .collect(Collectors.toList());  // Collect results into a list
    }

    public static void main(String[] args) {
        // Example 1: Convert list of strings to their lengths
        List<String> words = Arrays.asList("hello", "java", "stream");
        List<Integer> wordLengths = applyFunction(words, String::length);
        System.out.println("Word lengths: " + wordLengths); // Output: [5, 4, 6]

        // Example 2: Square a list of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<Integer> squares = applyFunction(numbers, n -> n * n);
        System.out.println("Squares: " + squares); // Output: [1, 4, 9, 16]
    }
}
