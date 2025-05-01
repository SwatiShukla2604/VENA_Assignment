package CollectionAssignments.Ques6LibraryCatalog;

import java.util.Objects;

// This class represents a Book entity with title, author, and publication year
public class Book {
    private String title;
    private String author;
    private int publicationYear;

    // Constructor to initialize Book object with title, author, and year
    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    // Getter methods for each field (used for access and sorting)
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    // equals() method determines if two Book objects are logically equal
    // It compares title, author, and publication year
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Check if both references point to the same object
        if (o == null || getClass() != o.getClass()) return false; // Check for null or different class
        Book book = (Book) o; // Typecast to Book for field comparisons
        return publicationYear == book.publicationYear &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }

    // hashCode() generates an integer used by HashSet/HashMap for placing objects in memory "buckets"
    // ✅ Important: If two objects are "equal" (equals() returns true), they MUST have the same hashCode
    // ✅ Objects.hash(...) makes it easy and safe to generate hash codes from multiple fields
    // ✅ It is null-safe: if title or author is null, it won't throw an error
    @Override
    public int hashCode() {
        return Objects.hash(title, author, publicationYear);
    }

    // toString() helps print the Book in a readable format
    @Override
    public String toString() {
        return "\"" + title + "\" by " + author + " (" + publicationYear + ")";
    }
}
