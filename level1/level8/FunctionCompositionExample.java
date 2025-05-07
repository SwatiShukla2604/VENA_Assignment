
// Question 2: Compose two functions:
// One for string parsing (String -> Integer)
// One for doubling the number (Integer -> Integer)

package Functional_Programming_Assignment.level1.level8;

import java.util.function.Function;

public class FunctionCompositionExample {
    public static void main(String[] args) {
        // Function to convert String to Integer
        Function<String, Integer> parseInt = Integer::parseInt;

        // Function to double the Integer
        Function<Integer, Integer> doubleValue = n -> n * 2;

        // Compose both functions using andThen()
        // First parse string to int, then double it
        Function<String, Integer> parseAndDouble = parseInt.andThen(doubleValue);

        // Sample input
        String input = "15";
        int result = parseAndDouble.apply(input);

        System.out.println("Original string: " + input);
        System.out.println("Parsed and doubled value: " + result);
    }
}
