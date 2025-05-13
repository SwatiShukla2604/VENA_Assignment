package exceptionhandling.Ques10;

/*
 * Question 9 (Part 2): Properly using control flow instead of exceptions
 *
 * This example uses a `break` to exit the loop when the condition is met,
 * which is the correct approach.
 */


public class GoodControlFlow {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 7, 9};

        for (int number : numbers) {
            System.out.println("Checking: " + number);
            if (number == 5) {
                System.out.println("Found 5, breaking using control flow (good)");
                break; // Properly exit loop
            }
        }
    }
}

