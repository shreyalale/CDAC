package com.cdac.dao;
import static com.cdac.utils.DBUtils.*;
import java.sql.*;

public class BankAccountDaoImpl implements BankAccountDao {
	private Connection connection;
	private CallableStatement cst1;
	
	public BankAccountDaoImpl() throws SQLException{
       connection = openConnection();
     // 1. get cn
       String sql="{? = call transfer_funds_func(?,?,?)}";
     //2 . create CST
       cst1=connection.prepareCall(sql);
     //3. register OUT param
       cst1.registerOutParameter(1, Types.DOUBLE);
       System.out.println("bank account dao created!");

	}
	public double transferFunds(int srcId, int destId, double transferAmount) throws SQLException {
		cst1.setInt(2, srcId);
		cst1.setInt(3, destId);
		cst1.setDouble(4, transferAmount);
		//2. exec stored procedure.
		cst1.execute();		
		//3.return the result.
		return cst1.getDouble(1);
		
	}
	public void cleanUp() throws SQLException {
		if(cst1 != null)
			cst1.close();
		closeConnection();
		System.out.println("Cleaned up resources.");
	}
	
}

	

