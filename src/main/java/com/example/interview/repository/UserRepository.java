package com.example.interview.repository;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.example.interview.entity.User;

public class UserRepository {

    private static final String URL = "jdbc:h2:mem:testdb";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "password";

    public void save(User user) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement stmt = conn.createStatement()) {

            String sql = "INSERT INTO users (username, password, email) VALUES ('"
                + user.getUsername() + "', '" + user.getPassword() + "', '" + user.getEmail() + "')";
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users")) {

            while (rs.next()) {
                User user = new User(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("email")
                );
                users.add(user);
            }
        } catch (SQLException _) {
        }
        return users;
    }
}

