/**
 Use a lambda expression to sort a list of strings alphabetically*/

package Functional_Programming_Assignment.level1;

import java.util.Arrays;
import java.util.List;

public class SortExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Banana", "Apple", "Orange");

        // Sort list alphabetically using lambda
        words.sort((a, b) -> a.compareTo(b));

        System.out.println(words);  // [Apple, Banana, Orange]
    }
}
