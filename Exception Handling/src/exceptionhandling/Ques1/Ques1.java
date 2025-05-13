package exceptionhandling.Ques1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Custom exception for data processing errors
class DataProcessingException extends Exception {
    public DataProcessingException(String message) {
        super(message);
    }
}

// This class simulates reading data from a file
class ReadData {
    public void readData() throws IOException {
        // Simulating reading from a file, using a simple text file
        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
            String line = reader.readLine(); // Reading the first line
            if (line == null) {
                throw new IOException("File is empty or not found.");
            }
            System.out.println("Data Read: " + line);
        } catch (IOException e) {
            throw new IOException("Error reading from the file: " + e.getMessage());
        }
    }
}

// This class handles data processing logic and exception propagation
class ProcessData {
    private ReadData readData;

    public ProcessData() {
        readData = new ReadData();
    }

    public void processData() throws DataProcessingException {
        try {
            // Calling readData() to simulate reading from file
            readData.readData();
        } catch (IOException e) {
            // Catch IOException and throw custom exception DataProcessingException
            throw new DataProcessingException("Error occurred while processing data: " + e.getMessage());
        }
    }
}

// Main class to simulate the flow and log exceptions
public class Ques1{
    public static void main(String[] args) {
        ProcessData processData = new ProcessData();

        try {
            // Trying to process data
            processData.processData();
        } catch (DataProcessingException e) {
            // Catch the custom exception and log the error
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}
