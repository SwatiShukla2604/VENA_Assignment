
// Question 1: Build a reusable pipeline of 3 functions:
// trim, lowercase, and remove punctuation from strings.
package Functional_Programming_Assignment.level1.level8;
import java.util.function.Function;

public class StringCleanerPipeline {
    public static void main(String[] args) {
        // Step 1: Function to trim whitespace
        Function<String, String> trim = String::trim;

        // Step 2: Function to convert to lowercase
        Function<String, String> toLower = String::toLowerCase;

        // Step 3: Function to remove punctuation using regex
        Function<String, String> removePunctuation = s -> s.replaceAll("\\p{Punct}", "");

        // Step 4: Compose all functions into a single pipeline using andThen()
        Function<String, String> cleanPipeline = trim
                .andThen(toLower)
                .andThen(removePunctuation);

        // Sample input
        String raw = "  Hello, World! It's JAVA.  ";
        String cleaned = cleanPipeline.apply(raw);

        System.out.println("Original: " + raw);
        System.out.println("Cleaned: " + cleaned);
    }
}
