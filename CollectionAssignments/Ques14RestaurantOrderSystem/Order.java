package CollectionAssignments.Ques14RestaurantOrderSystem;

// Class to represent a single order
public class Order {
    private Integer orderId;
    private String itemName;

    public Order(Integer orderId, String itemName) {
        this.orderId = orderId;
        this.itemName = itemName;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public String getItemName() {
        return itemName;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Item: " + itemName;
    }
}

