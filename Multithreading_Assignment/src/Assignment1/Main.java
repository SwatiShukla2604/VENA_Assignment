/** Assignment 1: Multi-threaded Logging System
 Background:
 You're building a high-throughput logging system for a large-scale application. Logs are generated from various parts of the system and should be stored in the order received, without blocking the producers.
 Requirements:
 Part 1: Basic Logging System
 Implement a class Logger with the following features:
 Method: void log(String message)
 Accepts log messages from multiple threads concurrently.
 Stores the messages in the order they were received.
 Uses a separate thread to flush logs every 5 seconds to the console (simulate disk).
 Part 2: Graceful Shutdown
 Provide a method void shutdown() that:
 Ensures all pending logs are flushed.
 Terminates the logging thread cleanly.
 Part 3: Stress Simulation
 Simulate 100 threads each logging 100 messages.
 Ensure that the messages do not get lost or printed out of order.
 Bonus Requirements:
 Support log levels (INFO, WARN, ERROR)
 Add timestamps to log entries
 Provide optional file-based flushing instead of console (via configuration)*/


package Assignment1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Logger logger = new Logger();
        Random random = new Random();

        // Create and start 100 threads, each logging 100 messages
        Thread[] threads = new Thread[100];

        for (int i = 0; i < 100; i++) {
            final int threadId = i;
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    // Randomly pick a log level
                    LogLevel[] levels = LogLevel.values();
                    LogLevel randomLevel = levels[random.nextInt(levels.length)];

                    // Log the message with random level
                    logger.log(randomLevel, "Thread " + threadId + " - Message " + j);
                }
            });
            threads[i].start();
        }

        // Wait for all threads to complete
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Shutdown logger after all logging is done
        logger.shutdown();
    }
}
