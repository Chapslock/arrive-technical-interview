package com.example.interview.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.interview.entity.User;
import com.example.interview.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService = new UserService();

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        userService.saveUser(user);
        return "User registered successfully";
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
