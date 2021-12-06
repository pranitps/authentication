package com.mybank.restservice.dto;

public class ResponseDTO {

    private boolean isValid;

    
    public ResponseDTO(boolean isValid) {
		super();
		this.isValid = isValid;
	}


	public boolean isValid() {
        return isValid;
    }

}
