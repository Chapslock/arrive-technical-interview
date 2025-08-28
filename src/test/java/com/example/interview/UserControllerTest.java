package com.example.interview;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import com.example.interview.controller.UserController;
import com.example.interview.entity.User;

@SpringBootTest
public class UserControllerTest {

    private UserController userController;

    @BeforeEach
    void setUp() {
        userController = new UserController();
    }

    @Test
    void testRegisterUser() {
        User user = new User(1, "alice", "password123", "alice@example.com");
        String response = userController.registerUser(user);

        assertEquals("User registered successfully", response);
    }

    @Test
    void testRegisterUserWithNullFields() {
        User user = new User(2, null, null, null);
        String response = userController.registerUser(user);

        assertNotNull(response);
    }

    @Test
    void testGetAllUsers() {
        List<User> users = userController.getAllUsers();

        assertNotNull(users);
    }

    @Test
    void testPasswordStored() {
        User user = new User(3, "bob", "mypassword", "bob@example.com");
        userController.registerUser(user);

        List<User> users = userController.getAllUsers();
        assertTrue(users.stream()
            .anyMatch(u -> u.getPassword().equals("mypassword")));
    }

    @Test
    void testInterrupts() throws InterruptedException {
        Thread.sleep(1000);
        List<User> users = userController.getAllUsers();
        assertNotNull(users);
    }
}

