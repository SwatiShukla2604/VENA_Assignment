// Question: You have a list of Order objects, each with a list of Items.
// Return a flat list of all item names.

package Functional_Programming_Assignment.level1.level7;

import java.util.*;
import java.util.stream.Collectors;

class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
}

class Order {
    private int id;
    private List<Item> items;

    public Order(int id, List<Item> items) {
        this.id = id;
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }
}

public class FlatItemList {

    public static void main(String[] args) {
        // Create some sample items
        Item item1 = new Item("Pen", 10.0);
        Item item2 = new Item("Book", 50.0);
        Item item3 = new Item("Pencil", 5.0);
        Item item4 = new Item("Notebook", 40.0);

        // Create sample orders (each with a list of items)
        Order order1 = new Order(1, Arrays.asList(item1, item2));
        Order order2 = new Order(2, Arrays.asList(item3, item4));

        // List of orders
        List<Order> orders = Arrays.asList(order1, order2);

        // Stream logic to flatten all items and get their names
        List<String> allItemNames = orders.stream()
                .flatMap(order -> order.getItems().stream()) // flatten all items into one stream
                .map(Item::getName) // get item name
                .collect(Collectors.toList()); // collect into list

        // Output result
        System.out.println("All item names: " + allItemNames);
    }
}
