/**   Problem 7: Movie Rating Aggregator (Map, List)
 Users rate movies between 1-5.
 •	Store movie name -> list of ratings.
 •	Compute and display average rating per movie sorted descending.
   */

package CollectionAssignments.Ques7MovieRatingAggregator;

import java.util.*;

/**
 * This class collects ratings for movies and calculates average ratings,
 * then displays them in descending order (highest rated first).
 */
public class MovieRatingAggregator {

    public static void main(String[] args) {
        // Creating a map to store movie name → list of ratings
        // Example: "Inception" → [5, 4, 5]
        Map<String, List<Integer>> movieRatings = new HashMap<>();

        // Adding some example ratings
        addRating(movieRatings, "Inception", 5);
        addRating(movieRatings, "Inception", 4);
        addRating(movieRatings, "Matrix", 3);
        addRating(movieRatings, "Matrix", 4);
        addRating(movieRatings, "Interstellar", 5);
        addRating(movieRatings, "Matrix", 4);
        addRating(movieRatings, "Inception", 5);
        addRating(movieRatings, "EmptyMovie", null); // edge case: null rating

        // Map to store final average rating for each movie
        Map<String, Double> movieToAverage = new HashMap<>();

        // Loop through each movie entry in the map
        for (Map.Entry<String, List<Integer>> entry : movieRatings.entrySet()) {
            // Get movie name (key)
            String movie = entry.getKey();

            // Get the list of ratings for that movie (value)
            List<Integer> ratings = entry.getValue();

            // Edge case: If movie exists but no valid ratings are present
            if (ratings == null || ratings.isEmpty()) {
                movieToAverage.put(movie, 0.0); // Give default average 0.0
                continue; // Move to next movie
            }

            // Calculate sum of ratings
            int sum = 0;
            for (int r : ratings) {
                sum += r;
            }

            // Calculate average = sum / number of ratings
            double average = (double) sum / ratings.size();

            // Store average in new map
            movieToAverage.put(movie, average);
        }

        // Convert the average map to a list so we can sort it
        List<Map.Entry<String, Double>> sortedList = new ArrayList<>(movieToAverage.entrySet());

        // Sort movies in descending order based on average rating
        sortedList.sort((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()));
        // Explanation: e2 comes before e1 for descending order

        // Print the result
        System.out.println("\nAverage Ratings (High to Low):");
        for (Map.Entry<String, Double> entry : sortedList) {
            // Print movie name and average rating (not formatted to 2 decimal places)
            System.out.println(" - " + entry.getKey() + ": " + entry.getValue());
        }
    }

    /**
     * Utility method to add a rating to a movie.
     * Handles edge cases like null ratings or new movie names.
     */
    private static void addRating(Map<String, List<Integer>> map, String movie, Integer rating) {
        // If the movie name is not yet in the map, add it with an empty list
        map.putIfAbsent(movie, new ArrayList<>());

        // If rating is not null and in valid range, add it to the list
        if (rating != null && rating >= 1 && rating <= 5) {
            map.get(movie).add(rating);
        }
        // Else ignore invalid rating (null or out of 1-5 range)
    }
}
