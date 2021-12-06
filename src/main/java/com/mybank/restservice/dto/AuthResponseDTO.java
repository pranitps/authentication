package com.mybank.restservice.dto;

public class AuthResponseDTO {

	private String provider;
	
	private boolean isValid;

	
	public AuthResponseDTO(String provider, boolean isValid) {
		super();
		this.provider = provider;
		this.isValid = isValid;
	}

	public String getProvider() {
		return provider;
	}

	public boolean isValid() {
		return isValid;
	}

}
