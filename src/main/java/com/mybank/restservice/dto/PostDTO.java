package com.mybank.restservice.dto;

public class PostDTO {

    private String accountNumber;

    
    public PostDTO(String accountNumber) {
		super();
		this.accountNumber = accountNumber;
	}

	public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
