/**  Problem 9: Leaderboard Tracker (TreeSet, Comparator)
 Track player scores using TreeSet<Player>  sorted by score descending.
 •	Update a player's score and maintain correct leaderboard order.
  */

package CollectionAssignments.Ques9LeaderboardTracker;

public class Main {
    public static void main(String[] args) {
        try {
            // Create leaderboard instance
            Leaderboard leaderboard = new Leaderboard();

            // Add players to leaderboard
            leaderboard.addOrUpdatePlayer("Alice", 80);
            leaderboard.addOrUpdatePlayer("Bob", 95);
            leaderboard.addOrUpdatePlayer("Charlie", 85);

            // Display initial leaderboard
            leaderboard.printLeaderboard();

            System.out.println("\nUpdating Alice's score to 98...");
            leaderboard.addOrUpdatePlayer("Alice", 98);

            // Display updated leaderboard
            leaderboard.printLeaderboard();

            System.out.println("\nTrying to add a player with null name...");
            leaderboard.addOrUpdatePlayer(null, 50); // handled with message

        } catch (Exception e) {
            // Handle any unexpected errors gracefully
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}
