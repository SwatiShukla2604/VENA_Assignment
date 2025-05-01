package CollectionAssignments.Ques5ProductCatalog;

/**
 * Main class to run the product catalog example.
 */
public class Main {
    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog();

        try {
            // Adding valid products
            catalog.addProduct(new Product(101, "Keyboard", 49.99, 4.4, 150));
            catalog.addProduct(new Product(102, "Mouse", 25.00, 4.8, 300));
            catalog.addProduct(new Product(103, "Monitor", 199.99, 4.8, 80));
            catalog.addProduct(new Product(104, "Laptop Stand", 35.99, 4.4, 120));
            catalog.addProduct(new Product(105, "Webcam", 69.00, 4.5, 100));
            catalog.addProduct(new Product(106, "Mouse", 27.00, 4.8, 300)); // same name, same rating as another

            // This will throw exception due to negative stock
            catalog.addProduct(new Product(107, "USB Cable", 5.99, 4.0, -10));
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid product: " + e.getMessage());
        }

        // Print sorted output
        catalog.printSortedByRatingThenName();
    }
}

