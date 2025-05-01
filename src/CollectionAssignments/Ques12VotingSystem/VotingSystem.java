package CollectionAssignments.Ques12VotingSystem;

import java.util.*;

public class VotingSystem {
    // Map to hold candidate names and their vote counts
    private Map<String, Integer> voteMap;

    // Constructor initializes the vote map
    public VotingSystem() {
        voteMap = new HashMap<>();
    }

    // Method to cast a vote for a candidate
    public void castVote(String candidate) {
        // Check if the candidate name is valid (not null or empty)
        if (candidate == null || candidate.trim().isEmpty()) {
            System.out.println("Invalid candidate name. Vote not counted.");
            return;
        }

        // Step-by-step vote count update for clarity:

        // Step 1: Get the current number of votes for this candidate
        Integer currentVotes = voteMap.getOrDefault(candidate, 0);

        // Step 2: Add one vote
        Integer updatedVotes = currentVotes + 1;

        // Step 3: Store the updated vote count back into the map
        voteMap.put(candidate, updatedVotes);
    }

    // Method to display results sorted by vote count in descending order
    public void displayResults() {
        System.out.println("\n--- Voting Results (Highest to Lowest) ---");

        // Convert the map entries into a list so we can sort them
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(voteMap.entrySet());

        // Sort the list using a comparator to order by vote count (high to low)
        sortedList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        // Print each candidate and their vote count
        for (Map.Entry<String, Integer> entry : sortedList) {
            System.out.println("Candidate: " + entry.getKey() + " - Votes: " + entry.getValue());
        }
    }
}

