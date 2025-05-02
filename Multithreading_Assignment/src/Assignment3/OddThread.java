package Assignment3;

/**
 * OddThread is a Runnable that prints odd numbers using SharedPrinter.
 */
public class OddThread implements Runnable {

    private final SharedPrinter printer;

    public OddThread(SharedPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.printOdd(); // Call the method to print odd numbers
    }
}

