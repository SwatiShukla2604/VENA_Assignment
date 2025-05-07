/**Compose two functions: one that converts string to uppercase and one that appends “!”.*/

package Functional_Programming_Assignment.level1.level4;

import java.util.function.Function;

public class ComposeFunctionsExample {
    public static void main(String[] args) {
        // Step 1: Create first function: convert string to uppercase
        Function<String, String> toUpperCase = str -> str.toUpperCase();

        // Step 2: Create second function: add "!" at the end
        Function<String, String> addExclamation = str -> str + "!";

        // Step 3: Compose functions using 'andThen' (first uppercase, then add "!")
        Function<String, String> composed = toUpperCase.andThen(addExclamation);

        // Step 4: Apply the composed function to input
        String result = composed.apply("hello");

        // Output: "HELLO!"
        System.out.println("Composed result: " + result);
    }
}

