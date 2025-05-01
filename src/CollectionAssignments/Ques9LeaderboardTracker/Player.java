package CollectionAssignments.Ques9LeaderboardTracker;

import java.util.Objects;

public class Player {
    private String name;
    private Integer score;

    // Constructor to initialize player with name and score
    public Player(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for score
    public Integer getScore() {
        return score;
    }

    // Setter for score
    public void setScore(Integer score) {
        this.score = score;
    }

    // Used to compare Player objects based on name (for finding/removing)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    // For display purposes
    @Override
    public String toString() {
        return name + " - " + score;
    }
}
