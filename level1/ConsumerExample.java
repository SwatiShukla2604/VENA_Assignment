/** Use a Consumer<String> to print a string in uppercase.*/

package Functional_Programming_Assignment.level1;

import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        // Consumer takes a string and prints it in uppercase
        Consumer<String> printUpperCase = str -> System.out.println(str.toUpperCase());

        printUpperCase.accept("functional");  // FUNCTIONAL
    }
}
