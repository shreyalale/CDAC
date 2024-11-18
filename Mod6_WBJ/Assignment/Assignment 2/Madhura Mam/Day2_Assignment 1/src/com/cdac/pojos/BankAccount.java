package com.cdac.pojos;

public class BankAccount {
	private int accId;
	private String customerName;
	private String acType;
	private double balance;
	public int getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAcType() {
		return acType;
	}
	public void setAcType(String acType) {
		this.acType = acType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "BankAccount [accId=" + accId + ", customerName=" + customerName + ", acType=" + acType + ", balance="
				+ balance + "]";
	}

}
