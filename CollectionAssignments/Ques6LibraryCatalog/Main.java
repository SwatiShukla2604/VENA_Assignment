package CollectionAssignments.Ques6LibraryCatalog;

// This is the main class where we test the LibraryCatalog functionality
public class Main {
    public static void main(String[] args) {

        // Step 1: Create an object of LibraryCatalog to manage our books
        LibraryCatalog catalog = new LibraryCatalog();

        // Step 2: Create some Book objects with different details
        Book b1 = new Book("The Hobbit", "J.R.R. Tolkien", 1937);
        Book b2 = new Book("The Fellowship of the Ring", "J.R.R. Tolkien", 1954);
        Book b3 = new Book("1984", "George Orwell", 1949);
        Book b4 = new Book("To Kill a Mockingbird", "Harper Lee", 1960);
        Book b5 = new Book("The Hobbit", "J.R.R. Tolkien", 1937); // Duplicate of b1

        // Step 3: Add books to genres
        catalog.addBook("Fantasy", b1);
        catalog.addBook("Fantasy", b2);
        catalog.addBook("Dystopian", b3);
        catalog.addBook("Classic", b4);

        // Step 4: Try adding a duplicate book (b5)
        catalog.addBook("Fantasy", b5); // Should not be added again

        // Step 5: Print books by genre — should be sorted by publication year
        System.out.println("\n------ Printing Genres ------\n");
        catalog.printBooksByGenre("Fantasy");
        catalog.printBooksByGenre("Dystopian");
        catalog.printBooksByGenre("Classic");

        // Step 6: Try printing a genre that doesn't exist
        catalog.printBooksByGenre("Science Fiction"); // Should show not found message
    }
}

