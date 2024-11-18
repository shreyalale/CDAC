package com.cdac.dao;

import java.sql.SQLException;

public interface BankAccountDao {
		//add a method to excec stored procedure-to transfer funds
		double transferFunds(int srcId, int destId, double transferAmount) throws SQLException;
		//add a method to clean up dao
		void cleanUp() throws SQLException;

}
