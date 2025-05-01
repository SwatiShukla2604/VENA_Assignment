package CollectionAssignments.Ques5ProductCatalog;

/**
 * Product class represents a product with:
 * - id: unique product identifier
 * - name: product name
 * - price: product price (non-negative)
 * - rating: from 0.0 to 5.0
 * - stock: available stock (must be ≥ 0)
 *
 * Question: Why validate in constructor?
 * To ensure no invalid product is created accidentally.
 */
public class Product {
    private Integer id;
    private String name;
    private Double price;
    private Double rating;
    private Integer stock;

    public Product(Integer id, String name, Double price, Double rating, Integer stock) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Product ID must be positive and non-null.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty.");
        }
        if (price == null || price < 0) {
            throw new IllegalArgumentException("Product price must be non-negative.");
        }
        if (rating == null || rating < 0.0 || rating > 5.0) {
            throw new IllegalArgumentException("Rating must be between 0.0 and 5.0.");
        }
        if (stock == null || stock < 0) {
            throw new IllegalArgumentException("Stock must be 0 or more.");
        }

        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.stock = stock;
    }

    // Getters for all fields
    public Integer getId() { return id; }
    public String getName() { return name; }
    public Double getPrice() { return price; }
    public Double getRating() { return rating; }
    public Integer getStock() { return stock; }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Price: $" + price +
                " | Rating: " + rating + " | Stock: " + stock;
    }
}

