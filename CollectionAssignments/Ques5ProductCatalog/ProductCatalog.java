package CollectionAssignments.Ques5ProductCatalog;

import java.util.*;

/**
 * ProductCatalog manages the catalog using a TreeMap.
 * TreeMap keeps products sorted by their IDs in ascending order.
 */
public class ProductCatalog {
    private TreeMap<Integer, Product> productMap;

    public ProductCatalog() {
        productMap = new TreeMap<>();
    }

    /**
     * Adds a product to the catalog.
     * Question: Why use try-catch?
     * So the system doesn't crash if user enters bad data.
     */
    public void addProduct(Product product) {
        try {
            if (productMap.containsKey(product.getId())) {
                System.out.println("Product ID already exists. Skipping: " + product.getId());
                return;
            }
            productMap.put(product.getId(), product);
        } catch (Exception e) {
            System.out.println("Error adding product: " + e.getMessage());
        }
    }

    /**
     * Prints all products sorted by:
     * 1. Descending rating
     * 2. Ascending name
     */
    public void printSortedByRatingThenName() {
        if (productMap.isEmpty()) {
            System.out.println("No products to display.");
            return;
        }

        // Question: Why use a list here?
        // Because TreeMap sorts by ID, and we need to sort by rating and name.
        List<Product> productList = new ArrayList<>(productMap.values());

        // Question: What does this Comparator do?
        // Sorts first by rating descending, then by name alphabetically.
        productList.sort((p1, p2) -> {
            int compareRating = Double.compare(p2.getRating(), p1.getRating());
            if (compareRating != 0) {
                return compareRating;
            }
            return p1.getName().compareToIgnoreCase(p2.getName());
        });

        System.out.println("\nProducts sorted by rating (desc), then name (asc):");
        for (Product product : productList) {
            System.out.println(product);
        }
    }
}

