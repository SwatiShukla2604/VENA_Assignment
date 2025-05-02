package Assignment3;

/**
 * SharedPrinter controls printing and synchronizes access between two threads:
 * one for odd numbers and one for even numbers using wait() and notify().
 */
public class SharedPrinter {

    private Integer number = 1;         // Current number to print
    private final Integer MAX = 100;    // Maximum number to print
    private Boolean isOddTurn = true;   // Start with odd number

    // Method to be called by Odd thread to print odd numbers
    public synchronized void printOdd() {
        while (number <= MAX) {
            while (!isOddTurn) {
                try {
                    wait(); // Wait if it's not odd's turn
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Safe to print odd number
            if (number <= MAX) {
                System.out.print(number + " ");
                number++;               // Increment number
                isOddTurn = false;      // Switch turn to even
                notify();               // Wake up even thread
            }
        }
    }

    // Method to be called by Even thread to print even numbers
    public synchronized void printEven() {
        while (number <= MAX) {
            while (isOddTurn) {
                try {
                    wait(); // Wait if it's not even's turn
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Safe to print even number
            if (number <= MAX) {
                System.out.print(number + " ");
                number++;               // Increment number
                isOddTurn = true;       // Switch turn to odd
                notify();               // Wake up odd thread
            }
        }
    }
}

