package com.cdac.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.cdac.pojos.User;
import com.cdac.utils.DBUtils;
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class UserDaoImpl implements UserDao {
    private Connection connection;
    private PreparedStatement pst1, pst2, pst3, pst4;

    public UserDaoImpl() throws SQLException {
        connection = DBUtils.getConnection();
        pst1 = connection.prepareStatement("SELECT * FROM users WHERE role = ?");
        pst2 = connection.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?");
        pst3 = connection.prepareStatement("UPDATE users SET status = ? WHERE id = ?");
        pst4 = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
        System.out.println("User DAO created!");
    }

    @Override
    public List<User> fetchUserDetailsByRole(String role) throws SQLException {
        List<User> users = new ArrayList<>();
        pst1.setString(1, role);
        try (ResultSet rst = pst1.executeQuery()) {
            while (rst.next()) {
                users.add(mapResultSetToUser(rst));
            }
        }
        return users;
    }

    @Override
    public User authenticateUser(String email, String password) throws SQLException {
        String hashedPassword = hashPassword(password);
        pst2.setString(1, email);
        pst2.setString(2, hashedPassword);
        try (ResultSet rst = pst2.executeQuery()) {
            if (rst.next()) {
                return mapResultSetToUser(rst);
            }
        }
        return null;
    }

    @Override
    public String updateVotingStatus(int voterId) throws SQLException {
        if (voterId <= 0) {
            throw new IllegalArgumentException("Invalid voter ID!");
        }
        pst3.setBoolean(1, true);
        pst3.setInt(2, voterId);
        int rowCount = pst3.executeUpdate();
        return rowCount == 1 ? "Updated voting status!" : "Updation failed!";
    }

    @Override
    public void cleanUp() throws SQLException {
        if (pst1 != null) pst1.close();
        if (pst2 != null) pst2.close();
        if (pst3 != null) pst3.close();
        if (pst4 != null) pst4.close();
        if (connection != null) connection.close();
        System.out.println("Resources cleaned up!");
    }

    public String hashPassword(String password) { // Made public
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    private User mapResultSetToUser(ResultSet rst) throws SQLException {
        return new User(rst.getInt(1), rst.getString(2), rst.getString(3),
                        rst.getString(4), rst.getString(5), rst.getDate(6),
                        rst.getBoolean(7), rst.getString(8));
    }
}
