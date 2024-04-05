package com.project.Bankingapp.DTO;

public class AccountDTO {
	
	private long id;
	private String accHolderName;
	private double balance;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAccHolderName() {
		return accHolderName;
	}
	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public AccountDTO() {
		// TODO Auto-generated constructor stub
	}
	public AccountDTO(long id, String accHolderName, double balance) {
		super();
		this.id = id;
		this.accHolderName = accHolderName;
		this.balance = balance;
	}
	
	
}
