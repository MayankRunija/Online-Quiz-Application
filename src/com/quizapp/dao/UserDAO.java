package com.quizapp.dao;

import com.quizapp.model.User;
import com.quizapp.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    public User authenticateUser(String username, String passwordHash) throws Exception {
        Connection conn = DatabaseConnection.getConnection();
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, username);
        stmt.setString(2, passwordHash);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return new User(rs.getInt("id"), rs.getString("username"),
                    rs.getString("password"), rs.getBoolean("is_admin"));
        }
        return null;
    }
}
