package com.cdac.dao;

import java.sql.SQLException;
import java.util.List;

import com.cdac.pojos.User;

public interface UserDao {
//add a method to fetch user details by role
	List<User>   fetchUserDetailsByRole(String role) throws SQLException;
	//add a method for voter registration
	String registerVoter(User newVoter) throws SQLException;
	
    //add method to change password
	String changePassword(int userId, String newPassword) throws SQLException;
	
	//add method to delete user
	String deleteUser(int userId) throws SQLException;
	//add method to user signin
	User signinUser(String email, String password) throws SQLException;
	
	//add a method to clean up DB resources;
	void cleanUp() throws SQLException;
}
