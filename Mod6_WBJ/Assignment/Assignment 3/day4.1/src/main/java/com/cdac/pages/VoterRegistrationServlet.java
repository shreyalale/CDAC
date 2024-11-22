package com.cdac.pages;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.dao.UserDaoImpl;
import com.cdac.utils.DBUtils;

@WebServlet("/voter_register")
public class VoterRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // Retrieve form data
            String firstName = request.getParameter("fn").trim();
            String lastName = request.getParameter("ln").trim();
            String email = request.getParameter("em").trim();
            String password = request.getParameter("pass").trim();
            String dobString = request.getParameter("dob");

            // Parse the date string to a Date object
            Date dob = Date.valueOf(dobString); // Ensure the date is in yyyy-MM-dd format
            boolean status = false; // Default status is false (user is not active yet)
            String role = "voter"; // Default role is voter

            // Hash the password
            UserDaoImpl userDao = new UserDaoImpl(); // Create an instance of UserDaoImpl
            String hashedPassword = userDao.hashPassword(password); // Use public hashPassword method

            // Get database connection
            conn = DBUtils.getConnection();

            // Prepare the SQL query to insert the new user into the database
            String sql = "INSERT INTO users (first_name, last_name, email, password, dob, status, role) VALUES (?, ?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, email);
            stmt.setString(4, hashedPassword); // Store hashed password
            stmt.setDate(5, dob);
            stmt.setBoolean(6, status);
            stmt.setString(7, role);

            // Execute the update (INSERT query)
            int rows = stmt.executeUpdate();

            if (rows > 0) {
                response.sendRedirect("login.html?message=Registration+Successful");
            } else {
                response.sendRedirect("error.html?message=Registration+Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.html?message=Internal+Error");
        } finally {
            // Clean up resources (close connection and statement)
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
