package exceptionhandling.Ques7;

/*
 * Question 7: Handling suppressed exceptions from multiple close operations
 *
 * Write a try-with-resources block where two custom resources both throw exceptions
 * in their close() method. Capture and display the suppressed exceptions from the primary one.
 */



class ResourceA implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("Closing ResourceA...");
        throw new Exception("Exception from ResourceA");
    }
}

class ResourceB implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("Closing ResourceB...");
        throw new Exception("Exception from ResourceB");
    }
}

public class Main{
    public static void main(String[] args) {
        // try-with-resources block where both resources will be closed automatically
        try (ResourceA a = new ResourceA(); ResourceB b = new ResourceB()) {
            System.out.println("Inside try-with-resources block.");
            // Normally you would use the resources here
        } catch (Exception e) {
            // Catch the main exception (from the first resource that failed to close)
            System.out.println("Caught main exception: " + e.getMessage());

            // Display any suppressed exceptions (from other resources that also failed to close)
            for (Throwable suppressed : e.getSuppressed()) {
                System.out.println("Suppressed: " + suppressed.getMessage());
            }
        }
    }
}
