package com.project.Bankingapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Account")
public class Account {
	@Id
	@Column(name = "Account_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Account_Holder_Name")
	private String accHolderName;
	
	@Column(name = "Balance")
	private Double balance;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccHolderName() {
		return accHolderName;
	}

	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Account(long id, String accHolderName, Double balance) {
		super();
		this.id = id;
		this.accHolderName = accHolderName;
		this.balance = balance;
	}
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

}
