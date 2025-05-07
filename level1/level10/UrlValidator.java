// Question: Given a list of URLs (strings), use streams to validate them using a Predicate<String> and return only valid ones.


package Functional_Programming_Assignment.level1.level10;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UrlValidator {

    // Simple URL validation predicate
    private static final Predicate<String> isValidUrl = url ->
            url.startsWith("http://") || url.startsWith("https://") && url.contains(".");

    // Method to filter only valid URLs
    public static List<String> getValidUrls(List<String> urls) {
        return urls.stream()
                .filter(isValidUrl) // apply our URL validation
                .collect(Collectors.toList()); // collect valid ones into a list
    }

    public static void main(String[] args) {
        List<String> inputUrls = Arrays.asList(
                "https://google.com",
                "http://example.com",
                "not_a_url",
                "ftp://invalid.com",
                "https://openai.com"
        );

        List<String> validUrls = getValidUrls(inputUrls);

        System.out.println("Valid URLs:");
        validUrls.forEach(System.out::println);
    }
}
