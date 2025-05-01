package CollectionAssignments.Ques6LibraryCatalog;

import java.util.*;

// This class manages the entire library catalog using Map<String, Set<Book>>
public class LibraryCatalog {

    // Map where each genre maps to a set of unique Book objects
    private Map<String, Set<Book>> genreToBooks;

    // Constructor initializes the empty catalog using a HashMap
    public LibraryCatalog() {
        genreToBooks = new HashMap<>();
    }

    // Method to add a Book to a specific genre
    public void addBook(String genre, Book book) {
        if (genre == null || book == null) {
            // Edge case: don't allow null values
            System.out.println("Genre or Book cannot be null.");
            return;
        }

        // ✅ EASY VERSION of getOrDefault:
        // Step 1: Try to get the set of books already stored under this genre
        Set<Book> books = genreToBooks.get(genre);

        // Step 2: If no such genre exists yet (i.e., it's the first time we're adding to it)
        if (books == null) {
            // Step 3: Create a new empty HashSet to hold books for this new genre
            books = new HashSet<>();
        }

        // Try to add the book — Set will prevent duplicates using equals() and hashCode()
        if (!books.add(book)) {
            System.out.println("Duplicate book detected. Not added: " + book);
        } else {
            // Put the updated set back into the map (important if we created a new set)
            genreToBooks.put(genre, books);
            System.out.println("Book added to genre '" + genre + "': " + book);
        }
    }

    // Method to print all books in a genre, sorted by publication year
    public void printBooksByGenre(String genre) {
        if (!genreToBooks.containsKey(genre)) {
            // Edge case: genre doesn't exist
            System.out.println("No such genre found: " + genre);
            return;
        }

        Set<Book> books = genreToBooks.get(genre);

        if (books.isEmpty()) {
            // Edge case: genre exists but has no books
            System.out.println("No books found in genre: " + genre);
            return;
        }

        // Convert Set to List for sorting
        List<Book> sortedBooks = new ArrayList<>(books);

        // ✅ EASIER SORTING SYNTAX using lambda
        // Sort the books by comparing their publication year
        sortedBooks.sort((book1, book2) -> book1.getPublicationYear() - book2.getPublicationYear());

        // Print books in sorted order
        System.out.println("Books in genre '" + genre + "' sorted by publication year:");
        for (Book book : sortedBooks) {
            System.out.println(" - " + book);
        }
    }
}

