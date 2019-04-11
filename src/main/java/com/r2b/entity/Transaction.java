package com.r2b.entity;

public class Transaction {

	private double value;
	
	private Account account;

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	@Override
	public String toString() {
		
		return "account : "+this.getAccount().getName()+" value : "+this.getValue();
	}
}
