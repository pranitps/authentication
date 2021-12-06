package com.mybank.restservice.data;


import javax.validation.constraints.NotNull;
import java.util.List;

public class AuthRequestData {

	//@NotNull(message = "Invalid request parameter.")
	private String accountNumber;
	
	private List<String> providers;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public List<String> getProviders() {
		return providers;
	}

	public void setProviders(List<String> providers) {
		this.providers = providers;
	}

	@Override
	public String toString() {
		return "AuthRequestData [accountNumber=" + accountNumber + ", providers=" + providers + "]";
	}

	
}
