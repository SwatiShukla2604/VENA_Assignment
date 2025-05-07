/* From a list of comments, count the number of comments by each user.*/


package Functional_Programming_Assignment.level1.level9;

import java.util.*;
import java.util.stream.Collectors;

// Class to represent each comment
class Comment {
    private String username;
    private String content;

    public Comment(String username, String content) {
        this.username = username;
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public String getContent() {
        return content;
    }
}

public class CommentCounter {
    public static void main(String[] args) {
        // Sample data
        List<Comment> comments = Arrays.asList(
                new Comment("alice", "Nice post!"),
                new Comment("bob", "Interesting!"),
                new Comment("alice", "Thanks for sharing."),
                new Comment("carol", "I agree with you."),
                new Comment("bob", "Very informative."),
                new Comment("alice", "Great work!")
        );

        // Count number of comments by each user
        Map<String, Long> commentCountByUser = comments.stream()
                .collect(Collectors.groupingBy(
                        Comment::getUsername,   // Group by username
                        Collectors.counting()   // Count how many comments per user
                ));

        // Print the result
        commentCountByUser.forEach((user, count) ->
                System.out.println(user + " made " + count + " comments."));
    }
}
