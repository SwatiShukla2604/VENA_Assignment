package CollectionAssignments.Ques9LeaderboardTracker;

import java.util.Comparator;
import java.util.TreeSet;

public class Leaderboard {

    // TreeSet maintains sorted order of players
    private TreeSet<Player> players;

    public Leaderboard() {
        // TreeSet with custom comparator: sort by score (desc), then name (asc)
        this.players = new TreeSet<>(new Comparator<Player>() {
            @Override
            public int compare(Player p1, Player p2) {
                int scoreComparison = p2.getScore().compareTo(p1.getScore()); // descending order
                if (scoreComparison != 0) {
                    return scoreComparison;
                } else {
                    return p1.getName().compareTo(p2.getName()); // ascending name to avoid duplicates
                }
            }
        });
    }

    // Add new player or update existing player score
    public void addOrUpdatePlayer(String name, Integer newScore) {
        if (name == null || newScore == null) {
            System.out.println("Error: Player name or score cannot be null.");
            return;
        }

        // First check if the player already exists
        Player existingPlayer = findPlayerByName(name);

        if (existingPlayer != null) {
            players.remove(existingPlayer); // Remove old entry
        }

        // Add new or updated player object to TreeSet
        players.add(new Player(name, newScore));
    }

    // Search player by name
    private Player findPlayerByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    // Display leaderboard in sorted order
    public void printLeaderboard() {
        System.out.println("Current Leaderboard (Highest to Lowest):");
        for (Player player : players) {
            System.out.println(player);
        }
    }
}
