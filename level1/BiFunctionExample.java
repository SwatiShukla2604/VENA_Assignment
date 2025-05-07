/** Create a BiFunction<Integer, Integer, Integer> that returns the sum*/

package Functional_Programming_Assignment.level1;

import java.util.function.BiFunction;

public class BiFunctionExample {
    public static void main(String[] args) {
        // BiFunction adds two integers
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;

        System.out.println(add.apply(10, 20));  // 30
    }
}
