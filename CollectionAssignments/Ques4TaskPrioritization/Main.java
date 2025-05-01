/**  Problem 4: Task Prioritization Engine (PriorityQueue, Comparator)
 Create a Task class with name, priority, deadline.
 •	Use PriorityQueue  to order by closest deadline, then highest priority.
 •	Poll and print tasks as they should be executed.
  */

package CollectionAssignments.Ques4TaskPrioritization;

import java.time.LocalDate;

/**
 * Main class to run and test TaskManager.
 */
public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        try {
            // Add valid tasks
            manager.addTask(new Task("Submit report", 7, LocalDate.of(2025, 5, 1)));
            manager.addTask(new Task("Team meeting", 8, LocalDate.of(2025, 5, 2)));
            manager.addTask(new Task("Fix bug", 10, LocalDate.of(2025, 5, 1))); // same date, higher priority
            manager.addTask(new Task("Review PR", 6, LocalDate.of(2025, 5, 3)));

            // Question: What happens if task is invalid?
            // It will throw an exception which is caught below
            manager.addTask(new Task("", 5, LocalDate.of(2025, 5, 1))); // Invalid name

        } catch (IllegalArgumentException e) {
            // Handles validation errors from Task constructor
            System.out.println("Task input error: " + e.getMessage());
        }

        // Execute all tasks in the desired order
        manager.executeTasks();
    }
}

