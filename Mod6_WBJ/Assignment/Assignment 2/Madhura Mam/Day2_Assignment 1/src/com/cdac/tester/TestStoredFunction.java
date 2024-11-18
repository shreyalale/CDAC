package com.cdac.tester;

import java.util.Scanner;

import com.cdac.dao.*;

public class TestStoredFunction {

	public static void main(String[] args) {
		try (
				Scanner sc = new Scanner(System.in);) {
			//Initialize the DAO
			BankAccountDao dao = new BankAccountDaoImpl();
			//Get User Inputs
			System.out.println("Enter source a/c id, destination a/c id, and transfer amount:");
			int srcId = sc.nextInt();
			int destId = sc.nextInt();
			double transferAmount = sc.nextDouble();
			
			double updatedBalance = dao.transferFunds(srcId, destId, transferAmount);
			System.out.println("Transfer successful. Updated destination account balance: " +updatedBalance);
			
			dao.cleanUp();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


