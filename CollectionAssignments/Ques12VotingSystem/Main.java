/** Voting System (Map<String, Integer>)
 Build a voting system that:
 •	Tallies votes per candidate
 •	Sorts by vote count descending
 */

package CollectionAssignments.Ques12VotingSystem;

public class Main {
    public static void main(String[] args) {
        // Create an instance of the voting system
        VotingSystem votingSystem = new VotingSystem();

        // Simulate casting some votes
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("");         // Invalid candidate (empty)
        votingSystem.castVote(null);       // Invalid candidate (null)

        // Show the results sorted by votes
        votingSystem.displayResults();
    }
}

