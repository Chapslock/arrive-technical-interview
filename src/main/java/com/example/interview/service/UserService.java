package com.example.interview.service;

import java.util.List;

import com.example.interview.entity.User;
import com.example.interview.repository.UserRepository;

public class UserService {

    private final UserRepository userRepository = new UserRepository();

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
