package CollectionAssignments.Ques4TaskPrioritization;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Manages task storage and execution.
 *
 * Question: Why use PriorityQueue here?
 * Because it gives us the next task (based on our Comparator logic)
 * in the right order — closest deadline first, then highest priority.
 */
public class TaskManager {
    // PriorityQueue that orders by deadline first, then by priority descending
    private PriorityQueue<Task> taskQueue;

    public TaskManager() {
        taskQueue = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                // Question: Why sort by deadline first?
                // Tasks with closer deadlines should be executed earlier.
                int deadlineCompare = t1.getDeadline().compareTo(t2.getDeadline());

                if (deadlineCompare != 0) {
                    return deadlineCompare; // Earlier deadline comes first
                }

                // Question: Why sort by priority descending if deadlines are same?
                // Higher priority (e.g., 10) should be done before lower one (e.g., 2)
                return Integer.compare(t2.getPriority(), t1.getPriority());
            }
        });
    }

    /**
     * Adds a task into the priority queue.
     *
     * Question: Why use try-catch here?
     * To safely catch any exception while adding (like null task).
     */
    public void addTask(Task task) {
        try {
            taskQueue.offer(task);
        } catch (Exception e) {
            System.out.println("Error adding task: " + e.getMessage());
        }
    }

    /**
     * Executes all tasks in correct order:
     * 1. Closest deadline first
     * 2. If same deadline, higher priority first
     */
    public void executeTasks() {
        if (taskQueue.isEmpty()) {
            System.out.println("No tasks to execute.");
            return;
        }

        System.out.println("\nExecuting tasks in order of deadline and priority:");
        while (!taskQueue.isEmpty()) {
            Task task = taskQueue.poll(); // Gets and removes next highest priority task
            System.out.println(task);
        }
    }
}

