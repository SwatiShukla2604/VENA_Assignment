/** Create a Function<String, Integer> that returns the length of a string.*/

package Functional_Programming_Assignment.level1;

import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        // Function takes a string and returns its length
        Function<String, Integer> stringLength = str -> str.length();

        System.out.println(stringLength.apply("Hello")); // 5
        System.out.println(stringLength.apply("Java"));  // 4
    }
}
