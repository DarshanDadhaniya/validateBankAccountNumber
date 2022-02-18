package com.example.demo.components;

import java.util.List;


public class BankAccount {
	private String accountNumber;
	private List<String> sourcesName;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public List<String> getSourcesName() {
		return sourcesName;
	}

	public void setSourcesName(List<String> sourcesName) {
		this.sourcesName = sourcesName;
	}

	public BankAccount() {
		super();
	}
}
