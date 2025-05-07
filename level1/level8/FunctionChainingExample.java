/*Implement compose() and andThen() examples using Function<T, R>.*/

package Functional_Programming_Assignment.level1.level8;

import java.util.function.Function;

public class FunctionChainingExample {

    public static void main(String[] args) {

        // Function 1: Parse a string to integer
        Function<String, Integer> parseInt = Integer::parseInt;

        // Function 2: Double the number
        Function<Integer, Integer> doubleIt = num -> num * 2;

        // --- Using andThen (parse first, then double)
        Function<String, Integer> parseThenDouble = parseInt.andThen(doubleIt);
        System.out.println("andThen Result (\"5\"): " + parseThenDouble.apply("5")); // Output: 10

        // --- Using compose (double first, then parse) - not valid here, shows limitation
        // Function<String, Integer> invalidCompose = doubleIt.compose(parseInt); // Valid
        Function<String, Integer> composeExample = doubleIt.compose(parseInt);
        System.out.println("compose Result (\"5\"): " + composeExample.apply("5")); // Output: 10
    }
}
