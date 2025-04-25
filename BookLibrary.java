/* 1 Book Library (Class & Object) Create a Book class with fields title, author, and ISBN. Include a constructor and a method to print details. Then, create a Library class to store a list of books and a method to search for a book by title.*/

import java.util.ArrayList;  // To store a list of books
import java.util.Scanner;   // For user input

// Book class represents a single book
class Book {
    String title;
    String author;
    String ISBN;

    // Constructor to initialize a Book object
    Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }

    // Method to print book details
    void printDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + ISBN);
        System.out.println("------------------------");
    }
}

// Library class manages a collection of books
class Library {
    // We use ArrayList to store multiple Book objects
    ArrayList<Book> books;

    // Constructor initializes the book list
    Library() {
        books = new ArrayList<>();
    }

    // Method to add a new book to the library
    void addBook(Book book) {
        books.add(book);
    }

    // Method to search for a book by its title
    void searchByTitle(String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) { // case-insensitive search
                System.out.println("Book Found:");
                book.printDetails();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Sorry! Book with title '" + title + "' not found.");
        }
    }
}

// Main class to run the program
public class BookLibrary {
    public static void main(String[] args) {
        Library myLibrary = new Library();  // Create a new Library object

        // Adding some books manually to the library
        myLibrary.addBook(new Book("Java Programming", "James Gosling", "12345"));
        myLibrary.addBook(new Book("Python Basics", "Guido van Rossum", "67890"));
        myLibrary.addBook(new Book("Data Structures", "Robert Lafore", "11223"));

        // Taking user input to search for a book
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title of the book to search: ");
        String searchTitle = scanner.nextLine();

        // Search and print result
        myLibrary.searchByTitle(searchTitle);
    }
}
