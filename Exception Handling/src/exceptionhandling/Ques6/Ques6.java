package exceptionhandling.Ques6;

/**
 * Question 6: Custom checked vs unchecked exceptions
 *
 * Define a custom checked exception (FileValidationException) and a runtime exception (CriticalSystemException).
 * Write code that shows where and why each type makes sense.
 */

class FileValidationException extends Exception {
    public FileValidationException(String message) {
        super(message);
    }
}

class CriticalSystemException extends RuntimeException {
    public CriticalSystemException(String message) {
        super(message);
    }
}

public class Ques6 {

    // Method that throws a CHECKED exception for recoverable issue
    public static void validateFileName(String fileName) throws FileValidationException {
        if (fileName == null || !fileName.endsWith(".txt")) {
            throw new FileValidationException("Invalid file name: must end with .txt");
        }
        System.out.println("File name validated successfully: " + fileName);
    }

    // Method that throws an UNCHECKED exception for critical issue
    public static void simulateCriticalFailure() {
        throw new CriticalSystemException("Critical failure: database corrupted");
    }

    public static void main(String[] args) {

        // Checked exception must be caught or declared
        try {
            validateFileName("data.csv"); // Invalid file, throws checked exception
        } catch (FileValidationException e) {
            System.out.println("Handled checked exception: " + e.getMessage());
        }

        // Unchecked exception: not forced to catch, but we can
        try {
            simulateCriticalFailure(); // Simulate crash
        } catch (CriticalSystemException e) {
            System.out.println("Handled unchecked exception: " + e.getMessage());
        }

        System.out.println("Program continued after handling exceptions.");
    }
}

