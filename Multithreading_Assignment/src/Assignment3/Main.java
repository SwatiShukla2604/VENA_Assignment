/** Assignment 3: Odd-Even Printer
 Background:
 Create a coordinated printing system where two threads print odd and even numbers up to 100 in sequence.
 Requirements:
 Thread A prints odd numbers (1, 3, 5...)
 Thread B prints even numbers (2, 4, 6...)
 Output must be in order: 1 2 3 4 5 ... 100
 Use wait() and notify() for coordination*/

package Assignment3;

/**
 * Main class starts both threads to print numbers 1 to 100 in alternating order.
 */
public class Main {
    public static void main(String[] args) {
        SharedPrinter printer = new SharedPrinter(); // Shared object for coordination

        // Create both threads
        Thread oddThread = new Thread(new OddThread(printer));
        Thread evenThread = new Thread(new EvenThread(printer));

        // Start both threads
        oddThread.start();
        evenThread.start();
    }
}
