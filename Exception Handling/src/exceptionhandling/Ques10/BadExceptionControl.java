package exceptionhandling.Ques10;

/*
 * Question 9 (Part 1): Incorrectly using exceptions to control flow
 *
 * This example shows bad practice: using an exception to exit a loop
 * when a simple break condition would suffice.
 */

public class BadExceptionControl {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 7, 9};

        try {
            for (int number : numbers) {
                System.out.println("Checking: " + number);
                if (number == 5) {
                    // Instead of breaking, we wrongly throw an exception to exit
                    throw new Exception("Found 5, breaking using exception (bad)");
                }
            }
        } catch (Exception e) {
            System.out.println("Exited loop with exception: " + e.getMessage());
        }
    }
}

