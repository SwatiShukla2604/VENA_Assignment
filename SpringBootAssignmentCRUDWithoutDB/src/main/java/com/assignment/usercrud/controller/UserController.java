package com.assignment.usercrud.controller;

import com.assignment.usercrud.model.User;
import com.assignment.usercrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // POST - Add user
    @PostMapping
    public String addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    // GET - All users
    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    // GET - Single user by ID
    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUserById(id);
    }

    // PUT - Full update
    @PutMapping("/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    // PATCH - Partial update
    @PatchMapping("/{id}")
    public String patchUser(@PathVariable int id, @RequestParam String name) {
        return userService.updateUserName(id, name);
    }

    // DELETE - Remove user
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }
}
