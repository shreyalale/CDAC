package com.cdac.utils;

import java.sql.*;

public class DBUtils {
	private static Connection connection;
	
	public static Connection openConnection() throws SQLException {
		//syntax: jdbc:subprotocol:subname
		String dburl = "jdbc:mysql://localhost:3306/advjava";
		connection = DriverManager.getConnection(dburl, "root", "cdac");
		return connection;
	}
    //add a method to close db connection
	public static void closeConnection() throws SQLException {
		if(connection != null)
			connection.close();
		System.out.println("Closed Connection.....");
	}
}
