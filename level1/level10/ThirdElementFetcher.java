// Question: Safely get the third element of a list using stream().skip(2).findFirst() and return Optional<T>

package Functional_Programming_Assignment.level1.level10;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ThirdElementFetcher {

    // Method to get the third element safely
    public static <T> Optional<T> getThirdElement(List<T> list) {
        return list.stream()
                .skip(2) // skip first two elements (index 0 and 1)
                .findFirst(); // now take the next element (index 2)
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        Optional<String> thirdName = getThirdElement(names);

        // Print result using Optional safely
        thirdName.ifPresentOrElse(
                name -> System.out.println("Third name: " + name),
                () -> System.out.println("No third element present")
        );
    }
}

