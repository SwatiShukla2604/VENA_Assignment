package CollectionAssignments.Ques4TaskPrioritization;

import java.time.LocalDate;

/**
 * Task class represents a unit of work with:
 * - name: name of the task
 * - priority: 1 (lowest) to 10 (highest)
 * - deadline: a date on or after today
 *
 * Question: Why validate in constructor?
 * To ensure no invalid task gets created, we throw IllegalArgumentException
 * if name is empty, priority is out of bounds, or deadline is in the past.
 */
public class Task {
    private String name;
    private Integer priority; // Use Integer instead of int as per user requirement
    private LocalDate deadline;

    public Task(String name, Integer priority, LocalDate deadline) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Task name cannot be empty.");
        }
        if (priority == null || priority < 1 || priority > 10) {
            throw new IllegalArgumentException("Priority must be between 1 and 10.");
        }
        if (deadline == null || deadline.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Deadline must be today or in the future.");
        }

        this.name = name;
        this.priority = priority;
        this.deadline = deadline;
    }

    public String getName() {
        return name;
    }

    public Integer getPriority() {
        return priority;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    // Returns a clean string when we print the object
    @Override
    public String toString() {
        return "Task: " + name + " | Priority: " + priority + " | Deadline: " + deadline;
    }
}

