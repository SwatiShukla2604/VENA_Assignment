/** Flight Booking Manager (Queue, Map)
 Use a Queue for booking requests and a Map for confirmed bookings.
 •	Process bookings FIFO and update map with seat numbers.
 */
package CollectionAssignments.Ques13FlightBookingManager;

public class Main {
    public static void main(String[] args) {
        // Create manager object
        FlightBookingManager manager = new FlightBookingManager();

        // Add booking requests
        manager.addBookingRequest("John");
        manager.addBookingRequest("Alice");
        manager.addBookingRequest("");       // Invalid
        manager.addBookingRequest(null);     // Invalid
        manager.addBookingRequest("Bob");

        // Process bookings in FIFO order
        manager.processNextBooking(); // John
        manager.processNextBooking(); // Alice
        manager.processNextBooking(); // Bob
        manager.processNextBooking(); // No more left

        // Show confirmed bookings
        manager.displayConfirmedBookings();
    }
}
