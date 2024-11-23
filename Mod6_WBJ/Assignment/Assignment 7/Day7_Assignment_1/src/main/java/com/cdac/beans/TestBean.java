package com.cdac.beans;

public class TestBean {
    private double num1;
    private double num2;
    private String operation;
    private double result;
	public double getNum1() {
		return num1;
	}
	public void setNum1(double num1) {
		this.num1 = num1;
	}
	public double getNum2() {
		return num2;
	}
	public void setNum2(double num2) {
		this.num2 = num2;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
    
    public void calculate() {
    	switch (operation) {
    	case "add":
    		result = num1 + num2;
    	    break;
    	case "substract":
    		result = num1 - num2;
    	    break;
    	case "multiply":
    		result = num1 * num2;
    		break;
    	case "divide":
    		result = num2 != 0 ? num1 / num2 : 0;
    		break;
    	default:
    		result = 0;
    	}
    }
    }
