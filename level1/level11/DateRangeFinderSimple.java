/* From a list of dates, return the earliest and latest date using a custom comparator and stream operations.*/

package Functional_Programming_Assignment.level1.level11;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class DateRangeFinderSimple {

    public static void main(String[] args) {
        // Step 1: Create a sample list of dates
        List<LocalDate> dates = Arrays.asList(
                LocalDate.of(2023, 5, 10),
                LocalDate.of(2021, 12, 25),
                LocalDate.of(2024, 1, 1),
                LocalDate.of(2022, 8, 15)
        );

        // Step 2: Find the earliest date using Stream.min and Comparator
        Optional<LocalDate> earliest = dates.stream()
                .min(Comparator.naturalOrder());

        // Step 3: Find the latest date using Stream.max and Comparator
        Optional<LocalDate> latest = dates.stream()
                .max(Comparator.naturalOrder());

        // Step 4: Print the results if present
        if (earliest.isPresent() && latest.isPresent()) {
            System.out.println("Earliest Date: " + earliest.get());
            System.out.println("Latest Date  : " + latest.get());
        } else {
            System.out.println("Date list is empty!");
        }
    }
}
