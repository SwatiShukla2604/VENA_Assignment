package exceptionhandling.Ques4;

// Step 1: Create a custom exception class
class CustomException extends Exception {
    public CustomException(String message, Throwable cause) {
        super(message, cause); // Pass both message and original exception
    }
}

public class Ques4 {

    // Step 2: A method that causes an error and wraps it in a custom exception
    public static void divideAndWrap() throws CustomException {
        try {
            int a = 10;
            int b = 0;
            int result = a / b;  // This will throw ArithmeticException
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            // Step 3: Catch original and wrap in new custom exception
            throw new CustomException("Division failed due to invalid input", e);
        }
    }

    public static void main(String[] args) {
        // Step 4: Catch the wrapped exception and print info
        try {
            divideAndWrap();
        } catch (CustomException e) {
            System.out.println("Custom Exception Caught: " + e.getMessage());
            System.out.println("Original Error: " + e.getCause());
        }
    }
}

