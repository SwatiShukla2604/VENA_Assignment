package Assignment1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// Simplified multi-threaded Logger class
public class Logger {
    private final BlockingQueue<LogMessage> logQueue = new LinkedBlockingQueue<>();
    private final Thread loggerThread;
    private volatile boolean running = true;

    public Logger() {
        // Start background thread to flush logs every 5 seconds
        loggerThread = new Thread(() -> {
            try {
                while (running || !logQueue.isEmpty()) {
                    LogMessage msg = logQueue.poll();
                    if (msg != null) {
                        System.out.println(msg);
                    } else {
                        Thread.sleep(5000); // Wait before checking again
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupt status
            }
        });

        loggerThread.start();
    }

    // Public method to add a log message
    public void log(LogLevel level, String message) {
        if (running) {
            logQueue.offer(new LogMessage(level, message));
        }
    }

    // Shutdown method to stop accepting new logs and flush all pending logs
    public void shutdown() {
        running = false;
        try {
            loggerThread.join(); // Wait for the flushing thread to finish
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Logger shutdown complete.");
    }
}
