/** Assignment 4: Thread Pool Image Processor
 Background:
 Simulate a parallel image processing pipeline using Java’s ExecutorService.
 Requirements:
 Given 50 image IDs (1–50), simulate processing (sleep 100ms)
 Return a message "Image X processed" for each
 Collect and print results in order using Callable + Future
 Bonus Requirements:
 Use a fixed thread pool of size 5
 Measure total execution time*/

package Assignment4; // 1

import java.util.ArrayList; // 2
import java.util.List;       // 3
import java.util.concurrent.*; // 4

/**
 * This class simulates parallel image processing using Java's thread pool.
 * It submits 50 image-processing tasks to a fixed thread pool of size 5,
 * waits for all results, prints them in order, and measures total execution time.
 */
public class Main { // 10

    public static void main(String[] args) { // 12

        long startTime = System.currentTimeMillis(); // 14

        ExecutorService executor = Executors.newFixedThreadPool(5); // 16

        List<Future<String>> futures = new ArrayList<>(); // 18

        for (Integer i = 1; i <= 50; i++) { // 20
            final Integer imageId = i; // 21

            Future<String> future = executor.submit(new Callable<String>() { // 23
                @Override
                public String call() { // 24
                    try {
                        Thread.sleep(100); // 26
                    } catch (InterruptedException e) {
                        return "Image " + imageId + " failed to process."; // 28
                    }
                    return "Image " + imageId + " processed"; // 30
                }
            });

            futures.add(future); // 33
        }

        for (Future<String> future : futures) { // 36
            try {
                System.out.println(future.get()); // 38
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Error retrieving result: " + e.getMessage()); // 40
            }
        }

        executor.shutdown(); // 43

        long endTime = System.currentTimeMillis(); // 45
        System.out.println("Total execution time: " + (endTime - startTime) + " ms"); // 46
    }
}

