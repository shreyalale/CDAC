package com.cdac.dao;

import java.sql.SQLException;
import java.util.List;
import com.cdac.pojos.User;

public interface UserDao {
    List<User> fetchUserDetailsByRole(String role) throws SQLException;
    User authenticateUser(String email, String password) throws SQLException;
    String updateVotingStatus(int voterId) throws SQLException;
    void cleanUp() throws SQLException;
}
