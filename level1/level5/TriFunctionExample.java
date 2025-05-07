package Functional_Programming_Assignment.level1.level5;

/**
 * Question:
 * Create your own functional interface called TriFunction<T, U, V, R>
 * that takes 3 arguments and returns a result.
 */

// Custom functional interface with three input types and one return type
@FunctionalInterface
interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v); // One abstract method for lambda use
}

public class TriFunctionExample {

    public static void main(String[] args) {
        // Lambda to calculate total bill after applying discount
        // Formula: (price * quantity) - discount
        TriFunction<Double, Integer, Double, Double> calculateBill = (price, quantity, discountPercent) -> {
            double total = price * quantity;
            double discount = total * (discountPercent / 100);
            return total - discount;
        };

        // Sample inputs
        double price = 100.0;
        int quantity = 5;
        double discountPercent = 10.0;

        // Using the TriFunction to calculate the bill
        double finalAmount = calculateBill.apply(price, quantity, discountPercent);
        System.out.println("Final Bill Amount: " + finalAmount);
    }
}
