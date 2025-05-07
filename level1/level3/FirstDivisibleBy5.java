/** Find the first element in a list of integers that is divisible by 5 using Stream API.
  */

// Question: Find the first element in a list of integers that is divisible by 5 using findFirst() and Optional.

package Functional_Programming_Assignment.level1.level3;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FirstDivisibleBy5 {

    public static void main(String[] args) {

        // A list of integers to search
        List<Integer> numbers = Arrays.asList(3, 7, 8, 11, 10, 13, 15);
/*If it exists, Optional will hold it.

If not, Optional will be empty — so we don't get a crash.

*/
        // Use stream to filter numbers divisible by 5 and get the first one
        Optional<Integer> result = numbers.stream()
                .filter(num -> num % 5 == 0)
                .findFirst();  // returns Optional<Integer>

        // Safe way to print result using Optional
        if (result.isPresent()) {
            System.out.println("First number divisible by 5: " + result.get());
        } else {
            System.out.println("No number divisible by 5 found");
        }


    }
}

