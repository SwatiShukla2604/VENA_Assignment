/** Problem 14: Restaurant Order System (Deque, List)
 Use a Deque<Order> for managing current orders.
 •	Allow adding/removing orders from both ends.
 •	Store history in a List<Order>.
  */

package CollectionAssignments.Ques14RestaurantOrderSystem;

public class Main {
    public static void main(String[] args) {
        // Create restaurant order system
        RestaurantOrderSystem system = new RestaurantOrderSystem();

        // Add some orders
        system.addOrderToBack(new Order(101, "Burger"));
        system.addOrderToFront(new Order(102, "Fries"));     // High priority
        system.addOrderToBack(new Order(103, "Pizza"));
        system.addOrderToFront(null);                        // Invalid

        // Display current orders
        system.displayCurrentOrders();

        // Process orders
        system.removeOrderFromFront(); // Should remove Fries
        system.removeOrderFromBack();  // Should remove Pizza
        system.removeOrderFromBack();  // Should remove Burger
        system.removeOrderFromFront(); // No orders left

        // Display current orders
        system.displayCurrentOrders();

        // Display order history
        system.displayOrderHistory();
    }
}

