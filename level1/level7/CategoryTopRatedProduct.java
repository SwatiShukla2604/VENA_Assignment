
// Question: Given a list of products with category and rating,
// return a map of category → highest-rated product name.

package Functional_Programming_Assignment.level1.level7;

import java.util.*;
import java.util.stream.Collectors;

class Product {
    private String name;
    private String category;
    private double rating;

    public Product(String name, String category, double rating) {
        this.name = name;
        this.category = category;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getRating() {
        return rating;
    }
}

public class CategoryTopRatedProduct {

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("iPhone", "Electronics", 4.5),
                new Product("Samsung TV", "Electronics", 4.7),
                new Product("Harry Potter", "Books", 4.9),
                new Product("Lord of the Rings", "Books", 4.8),
                new Product("Nike Shoes", "Clothing", 4.6),
                new Product("Adidas Jacket", "Clothing", 4.3)
        );

        // Group by category, then get the product with max rating, and map to its name
        Map<String, String> topRatedByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingDouble(Product::getRating)),
                                optionalProduct -> optionalProduct.map(Product::getName).orElse("No Product")
                        )
                ));

        // Print the result
        topRatedByCategory.forEach((category, productName) ->
                System.out.println("Category: " + category + ", Top Rated: " + productName));
    }
}
