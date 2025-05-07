/** Write a Predicate<String> that returns true if a string starts with “A”.*/

package Functional_Programming_Assignment.level1;

import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        // Predicate checks if string starts with "A"
        Predicate<String> startsWithA = str -> str.startsWith("A");

        // Test the predicate
        System.out.println(startsWithA.test("Apple"));   // true
        System.out.println(startsWithA.test("Banana"));  // false
    }
}

