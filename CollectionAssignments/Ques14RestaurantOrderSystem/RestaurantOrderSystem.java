package CollectionAssignments.Ques14RestaurantOrderSystem;

import java.util.*;

public class RestaurantOrderSystem {
    private Deque<Order> currentOrders;       // Stores current live orders
    private List<Order> orderHistory;         // Stores processed/removed orders

    public RestaurantOrderSystem() {
        currentOrders = new LinkedList<>();
        orderHistory = new ArrayList<>();
    }

    // Add order to the front (high priority order)
    public void addOrderToFront(Order order) {
        if (order == null) {
            System.out.println("Invalid order. Cannot add.");
            return;
        }
        currentOrders.addFirst(order);
        System.out.println("Order added to front: " + order);
    }

    // Add order to the back (normal priority order)
    public void addOrderToBack(Order order) {
        if (order == null) {
            System.out.println("Invalid order. Cannot add.");
            return;
        }
        currentOrders.addLast(order);
        System.out.println("Order added to back: " + order);
    }

    // Remove and process the order from front (like first come, first serve)
    public void removeOrderFromFront() {
        if (currentOrders.isEmpty()) {
            System.out.println("No current orders to remove.");
            return;
        }

        Order removedOrder = currentOrders.removeFirst(); // remove first order
        orderHistory.add(removedOrder); // store in history
        System.out.println("Processed (front): " + removedOrder);
    }

    // Remove and process the order from back (last order gets canceled/processed)
    public void removeOrderFromBack() {
        if (currentOrders.isEmpty()) {
            System.out.println("No current orders to remove.");
            return;
        }

        Order removedOrder = currentOrders.removeLast(); // remove last order
        orderHistory.add(removedOrder); // store in history
        System.out.println("Processed (back): " + removedOrder);
    }

    // Show all current orders
    public void displayCurrentOrders() {
        System.out.println("\n--- Current Orders ---");
        if (currentOrders.isEmpty()) {
            System.out.println("No current orders.");
            return;
        }

        for (Order order : currentOrders) {
            System.out.println(order);
        }
    }

    // Show processed order history
    public void displayOrderHistory() {
        System.out.println("\n--- Order History ---");
        if (orderHistory.isEmpty()) {
            System.out.println("No orders processed yet.");
            return;
        }

        for (Order order : orderHistory) {
            System.out.println(order);
        }
    }
}

