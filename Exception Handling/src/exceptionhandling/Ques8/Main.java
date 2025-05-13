package exceptionhandling.Ques8;

/*
 * Question 8: Programmatic Exception Handling Policy
 *
 * Implement a retry mechanism: write a method that attempts to read from a flaky service 3 times.
 * If it fails all 3 times, it throws a ServiceUnavailableException.
 */


// Custom exception to indicate the service is unavailable after retries
class ServiceUnavailableException extends Exception {
    public ServiceUnavailableException(String message) {
        super(message);
    }
}

// Simulates a flaky service that randomly fails
class FlakyService {
    private int callCount = 0;

    public String readData() throws Exception {
        callCount++;
        if (Math.random() < 0.7) { // 70% chance of failure
            throw new Exception("Service failed on attempt " + callCount);
        }
        return "Data received on attempt " + callCount;
    }
}

public class Main {

    // Method that retries the flaky service up to 3 times
    public static String callWithRetry(FlakyService service, int maxRetries) throws ServiceUnavailableException {
        int attempts = 0;
        while (attempts < maxRetries) {
            try {
                return service.readData(); // Try to read from service
            } catch (Exception e) {
                attempts++;
                System.out.println("Attempt " + attempts + " failed: " + e.getMessage());
                if (attempts == maxRetries) {
                    throw new ServiceUnavailableException("Service failed after " + maxRetries + " retries.");
                }
            }
        }
        return null; // This line is technically unreachable
    }

    public static void main(String[] args) {
        FlakyService service = new FlakyService();

        try {
            String result = callWithRetry(service, 3);
            System.out.println("Success: " + result);
        } catch (ServiceUnavailableException e) {
            System.out.println("Final failure: " + e.getMessage());
        }
    }
}

