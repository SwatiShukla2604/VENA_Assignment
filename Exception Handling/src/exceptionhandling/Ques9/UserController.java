package exceptionhandling.Ques9;

/*
 * Question 9: Chained Exceptions Across Layers
 *
 * Simulate a layered app:
 * - Repository throws SQLException.
 * - Service layer catches SQLException and wraps it in a ServiceLayerException.
 * - Controller layer catches ServiceLayerException and logs it.
 * Write code demonstrating this multi-layer exception wrapping.
 */

import java.sql.SQLException;

// Custom exception to represent service layer issues
class ServiceLayerException extends Exception {
    public ServiceLayerException(String message, Throwable cause) {
        super(message, cause);
    }
}

// Simulated Repository layer that throws SQLException
class UserRepository {
    public void getUserById(int id) throws SQLException {
        // Simulating failure from the database
        throw new SQLException("Failed to fetch user from DB");
    }
}

// Simulated Service layer that wraps SQLException in a ServiceLayerException
class UserService {
    private final UserRepository repository = new UserRepository();

    public void processUser(int id) throws ServiceLayerException {
        try {
            repository.getUserById(id); // May throw SQLException
        } catch (SQLException e) {
            // Wrapping low-level exception in a higher-level one
            throw new ServiceLayerException("Service failed while processing user : "+ e.getMessage(), e);
        }
    }
}

// Simulated Controller layer that catches and logs the ServiceLayerException
public class UserController {
    private final UserService service = new UserService();

    public void handleUserRequest(int id) {
        try {
            service.processUser(id);
            System.out.println("User processed successfully.");
        } catch (ServiceLayerException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Cause: " + e.getCause()); // Log the underlying SQLException
        }
    }

    public static void main(String[] args) {
        UserController controller = new UserController();
        controller.handleUserRequest(101);
    }
}

