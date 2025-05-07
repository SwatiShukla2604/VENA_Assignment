/**
 Write a Supplier<Double> that generates a random number.*/

package Functional_Programming_Assignment.level1;

import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        // Supplier provides a random number
        Supplier<Double> randomSupplier = () -> Math.random();

        System.out.println(randomSupplier.get());  // Example: 0.62839
    }
}
