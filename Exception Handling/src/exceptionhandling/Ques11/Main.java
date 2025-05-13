package exceptionhandling.Ques11;

/*
 * Question 11: Thread Exception Handling
 *
 * Write a multithreaded program where a child thread throws a RuntimeException.
 * Show how the main thread can detect and handle that exception using
 * Thread.setDefaultUncaughtExceptionHandler().
 */

public class Main {

    public static void main(String[] args) {

        // Step 1: Set a default uncaught exception handler
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                // This will be triggered if any thread terminates due to an uncaught exception
                System.out.println("Caught exception in thread: " + t.getName());
                System.out.println("Exception message: " + e.getMessage());
            }
        });

        // Step 2: Create and start a child thread that throws a RuntimeException
        Thread childThread = new Thread(() -> {
            System.out.println("Child thread started.");
            throw new RuntimeException("Simulated error in child thread");
        });

        childThread.start();

        // Step 3: Optionally wait for the child thread to finish
        try {
            childThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }

        System.out.println("Main thread finished.");
    }
}
