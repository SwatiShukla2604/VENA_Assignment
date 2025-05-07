// Question: Chain operations on a list of Orders: filter by date range, map to total amount, sum all totals.

package Functional_Programming_Assignment.level1.level10;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class OrderTotalCalculator {

    // Order class with date and amount
    static class Order {
        private LocalDate date;
        private double amount;

        public Order(LocalDate date, double amount) {
            this.date = date;
            this.amount = amount;
        }

        public LocalDate getDate() {
            return date;
        }

        public double getAmount() {
            return amount;
        }
    }

    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order(LocalDate.of(2023, 1, 10), 120.0),
                new Order(LocalDate.of(2022, 5, 5), 250.0),
                new Order(LocalDate.of(2023, 7, 25), 300.0),
                new Order(LocalDate.of(2024, 3, 10), 400.0)
        );

        // Define the range: 1 Jan 2023 to 31 Dec 2023
        LocalDate start = LocalDate.of(2023, 1, 1);
        LocalDate end = LocalDate.of(2023, 12, 31);

        // Stream pipeline
        double total = orders.stream()
                .filter(order -> !order.getDate().isBefore(start) && !order.getDate().isAfter(end)) // date in range
                .mapToDouble(Order::getAmount) // extract amount
                .sum(); // sum all amounts

        System.out.println("Total amount of 2023 orders: " + total);
    }
}
