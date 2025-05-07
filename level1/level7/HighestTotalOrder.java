// Question: Find the order with the highest total item price.

package Functional_Programming_Assignment.level1.level7;

import java.util.*;

class CustomerOrder {
    private int id;
    private List<ProductItem> items;

    public CustomerOrder(int id, List<ProductItem> items) {
        this.id = id;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public List<ProductItem> getItems() {
        return items;
    }

    // Helper method to calculate total price
    public double getTotalPrice() {
        return items.stream()
                .mapToDouble(ProductItem::getPrice)
                .sum();
    }
}

class ProductItem {
    private String name;
    private double price;

    public ProductItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

public class HighestTotalOrder {

    public static void main(String[] args) {
        // Sample items
        ProductItem item1 = new ProductItem("Pen", 10.0);
        ProductItem item2 = new ProductItem("Book", 50.0);
        ProductItem item3 = new ProductItem("Pencil", 5.0);
        ProductItem item4 = new ProductItem("Notebook", 40.0);
        ProductItem item5 = new ProductItem("Eraser", 3.0);

        // Sample orders
        CustomerOrder order1 = new CustomerOrder(101, Arrays.asList(item1, item2));
        CustomerOrder order2 = new CustomerOrder(102, Arrays.asList(item3, item4, item5));

        List<CustomerOrder> orders = Arrays.asList(order1, order2);

        // Find the order with the highest total price
        Optional<CustomerOrder> maxOrder = orders.stream()
                .max(Comparator.comparingDouble(CustomerOrder::getTotalPrice));

        // Output result
        if (maxOrder.isPresent()) {
            System.out.println("Order ID with highest total: " + maxOrder.get().getId());
            System.out.println("Total Price: " + maxOrder.get().getTotalPrice());
        } else {
            System.out.println("No orders found.");
        }
    }
}
