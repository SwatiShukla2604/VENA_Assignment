/* Simulate a batch job: given a list of jobs (name, status), return only failed job names in uppercase, sorted alphabetically.*/
package Functional_Programming_Assignment.level1.level11;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FailedJobsFilter {

    // Job class with name and status
    static class Job {
        String name;
        String status; // e.g., "SUCCESS", "FAILED"

        Job(String name, String status) {
            this.name = name;
            this.status = status;
        }
    }

    public static void main(String[] args) {
        // Step 1: Create a sample list of jobs
        List<Job> jobs = Arrays.asList(
                new Job("importData", "SUCCESS"),
                new Job("processInvoices", "FAILED"),
                new Job("sendEmails", "FAILED"),
                new Job("generateReport", "SUCCESS"),
                new Job("cleanUpTemp", "FAILED")
        );

        // Step 2: Stream pipeline to process jobs
        List<String> failedJobsUpper = jobs.stream()
                .filter(job -> job.status.equalsIgnoreCase("FAILED"))     // filter only failed jobs
                .map(job -> job.name.toUpperCase())                       // convert name to uppercase
                .sorted()                                                 // sort alphabetically
                .collect(Collectors.toList());                            // collect to list

        // Step 3: Print the failed job names
        System.out.println("Failed Jobs:");
        failedJobsUpper.forEach(System.out::println);
    }
}


