package Functional_Programming_Assignment.level1.level5;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Question:
 * Implement a function pipeline to process orders (e.g., filter by status,
 * sort by amount, map to customer name).
 */

// Order class with basic fields
class Order {
    private final String customerName;
    private final double amount;
    private final String status; // e.g., "COMPLETED", "PENDING"

    public Order(String customerName, double amount, String status) {
        this.customerName = customerName;
        this.amount = amount;
        this.status = status;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }
}

public class OrderProcessor {
    public static void main(String[] args) {

        // Sample order list
        List<Order> orders = Arrays.asList(
                new Order("Alice", 300.0, "COMPLETED"),
                new Order("Bob", 150.0, "PENDING"),
                new Order("Charlie", 200.0, "COMPLETED"),
                new Order("Diana", 400.0, "CANCELLED"),
                new Order("Eve", 100.0, "COMPLETED")
        );

        // Functional pipeline:
        // 1. Filter completed orders
        // 2. Sort by amount
        // 3. Map to customer names
        List<String> completedCustomerNames = orders.stream()
                .filter(order -> order.getStatus().equalsIgnoreCase("COMPLETED"))
                .sorted(Comparator.comparingDouble(Order::getAmount))
                .map(Order::getCustomerName)
                .collect(Collectors.toList());

        // Output result
        System.out.println("Completed Orders (Sorted by Amount): " + completedCustomerNames);
    }
}
