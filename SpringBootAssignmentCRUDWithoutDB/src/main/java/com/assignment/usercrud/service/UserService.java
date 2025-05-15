package com.assignment.usercrud.service;

import com.assignment.usercrud.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    // In-memory store using Map
    private Map<Integer, User> userMap = new HashMap<>();

    // Add user
    public String addUser(User user) {
        userMap.put(user.getId(), user);
        return "User added successfully!";
    }

    // Get all users
    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

    // Get user by ID
    public User getUserById(int id) {

        return userMap.get(id);

    }

    // Update full user (PUT)
    public String updateUser(int id, User updatedUser) {
        userMap.put(id, updatedUser);
        return "User updated successfully!";
    }

    // Partial update (PATCH)
    public String updateUserName(int id, String newName) {
        User existingUser = userMap.get(id);
        if (existingUser != null) {
            existingUser.setName(newName);
            return "User name updated!";
        }
        return "User not found!";
    }

    // Delete user
    public String deleteUser(int id) {
        userMap.remove(id);
        return "User deleted successfully!";
    }
}
