package Assignment3;

/**
 * EvenThread is a Runnable that prints even numbers using SharedPrinter.
 */
public class EvenThread implements Runnable {

    private final SharedPrinter printer;

    public EvenThread(SharedPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.printEven(); // Call the method to print even numbers
    }
}

