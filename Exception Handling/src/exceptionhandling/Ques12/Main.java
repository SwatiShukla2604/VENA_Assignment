package exceptionhandling.Ques12;

// Q12: Global exception handler using Thread.setDefaultUncaughtExceptionHandler()

public class Main {

    public static void main(String[] args) {

        // Step 1: Set the global uncaught exception handler
        Thread.setDefaultUncaughtExceptionHandler((thread, exception) -> {
            // This code runs automatically when any thread throws an uncaught exception
            System.out.println("Global Handler: An uncaught exception occurred!");
            System.out.println("Thread Name: " + thread.getName());
            System.out.println("Exception: " + exception.getClass().getSimpleName());
            System.out.println("Message: " + exception.getMessage());
        });

        // Step 2: Create and start a thread that throws an uncaught exception
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 running...");
            throw new RuntimeException("Oops! Something went wrong in thread 1");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2 running...");
            throw new IllegalArgumentException("Invalid argument in thread 2");
        });

        thread1.start();
        thread2.start();

        // Step 3: Main thread continues
        System.out.println("Main thread finished.");
    }
}

