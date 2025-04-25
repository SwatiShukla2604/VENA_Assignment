
/* 10 Inventory System (Object Arrays + Methods) Create a Product class with id, name, and price. Create an array of products in a Store class. Write methods to:
•	Display all products
•	Find product with highest price
•	Search product by name
*/
// Main.java

// Step 1: Product class
class Product {
    int id;
    String name;
    double price;

    // Constructor to initialize a product
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Method to display product info
    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Price: " + price);
    }
}

// Step 2: Store class
class Store {
    // Array to hold multiple Product objects
    Product[] products;

    // Constructor to initialize store with products
    public Store(Product[] products) {
        this.products = products;
    }

    // Method 1: Display all products
    public void displayAllProducts() {
        System.out.println("All Products in the Store:");
        for (Product p : products) {
            p.display();
        }
    }

    // Method 2: Find product with highest price
    public void findHighestPricedProduct() {
        if (products.length == 0) {
            System.out.println("No products in the store.");
            return;
        }

        Product max = products[0];

        for (Product p : products) {
            if (p.price > max.price) {
                max = p;
            }
        }

        System.out.println("\nProduct with the highest price:");
        max.display();
    }

    // Method 3: Search for a product by name
    public void searchProductByName(String searchName) {
        boolean found = false;

        System.out.println("\nSearch results for: " + searchName);

        for (Product p : products) {
            if (p.name.equalsIgnoreCase(searchName)) {
                p.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Product not found.");
        }
    }
}

// Step 3: Main class to test everything
public class InventorySystem {
    public static void main(String[] args) {

        // Create some product objects
        Product p1 = new Product(101, "Laptop", 75000.00);
        Product p2 = new Product(102, "Mouse", 1500.00);
        Product p3 = new Product(103, "Keyboard", 2500.00);
        Product p4 = new Product(104, "Monitor", 12000.00);

        // Put products into an array
        Product[] allProducts = {p1, p2, p3, p4};

        // Create store object with product array
        Store store = new Store(allProducts);

        // Call methods
        store.displayAllProducts();
        store.findHighestPricedProduct();
        store.searchProductByName("Mouse");
        store.searchProductByName("Tablet"); // Try searching for a non-existent product
    }
}