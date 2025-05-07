/* Given a list of books, generate a summary object with total count, average rating, and total price.*/


package Functional_Programming_Assignment.level1.level9;

import java.util.*;

class Book {
    private String title;
    private double price;
    private double rating;

    public Book(String title, double price, double rating) {
        this.title = title;
        this.price = price;
        this.rating = rating;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    public String getTitle() {
        return title;
    }
}

// Class to hold the summary
class BookSummary {
    private long totalBooks;
    private double totalPrice;
    private double averageRating;

    public BookSummary(long totalBooks, double totalPrice, double averageRating) {
        this.totalBooks = totalBooks;
        this.totalPrice = totalPrice;
        this.averageRating = averageRating;
    }

    public String toString() {
        return "Total Books: " + totalBooks + ", Total Price: " + totalPrice + ", Average Rating: " + averageRating;
    }
}

public class BookSummaryCalculator {

    public static BookSummary generateSummary(List<Book> books) {
        long count = books.size();

        double totalPrice = books.stream()
                .mapToDouble(Book::getPrice)
                .sum();

        double averageRating = books.stream()
                .mapToDouble(Book::getRating)
                .average()
                .orElse(0.0); // If list is empty

        return new BookSummary(count, totalPrice, averageRating);
    }

    public static void main(String[] args) {
        List<Book> bookList = Arrays.asList(
                new Book("Java Basics", 300.0, 4.5),
                new Book("Advanced Java", 500.0, 4.7),
                new Book("Spring Boot", 450.0, 4.6)
        );

        BookSummary summary = generateSummary(bookList);
        System.out.println(summary);
    }
}
