package CollectionAssignments.Ques13FlightBookingManager;

import java.util.*;

public class FlightBookingManager {
    private Queue<String> bookingQueue; // Queue to hold booking requests (FIFO)
    private Map<String, Integer> confirmedBookings; // Map to store confirmed bookings with seat numbers
    private Integer seatCounter; // Counter to assign seat numbers

    // Constructor: initializes queue, map, and seat number
    public FlightBookingManager() {
        bookingQueue = new LinkedList<>();
        confirmedBookings = new LinkedHashMap<>(); // maintains insertion order
        seatCounter = 1; // start seat numbers from 1
    }

    // Method to add a new booking request to the queue
    public void addBookingRequest(String customerName) {
        if (customerName == null || customerName.trim().isEmpty()) {
            System.out.println("Invalid customer name. Request not added.");
            return;
        }

        bookingQueue.offer(customerName); // add customer to queue
        System.out.println("Booking request added for: " + customerName);
    }

    // Method to process the next booking in queue
    public void processNextBooking() {
        if (bookingQueue.isEmpty()) {
            System.out.println("No booking requests to process.");
            return;
        }

        // Get the next customer in queue (FIFO order)
        String customer = bookingQueue.poll();

        // Assign seat number as an integer
        Integer seatNumber = seatCounter;
        seatCounter++; // increment for next booking

        // Store confirmed booking
        confirmedBookings.put(customer, seatNumber);
        System.out.println("Booking confirmed for " + customer + " - Seat: " + seatNumber);
    }

    // Method to display all confirmed bookings
    public void displayConfirmedBookings() {
        System.out.println("\n--- Confirmed Bookings ---");

        if (confirmedBookings.isEmpty()) {
            System.out.println("No bookings confirmed yet.");
            return;
        }

        // Print each customer and their seat number
        for (Map.Entry<String, Integer> entry : confirmedBookings.entrySet()) {
            System.out.println("Customer: " + entry.getKey() + " - Seat: " + entry.getValue());
        }
    }
}

