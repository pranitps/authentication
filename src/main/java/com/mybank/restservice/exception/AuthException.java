package com.mybank.restservice.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class AuthException {

    private final String message;
    private final HttpStatus status;
    private LocalDateTime localDateTime;


    public AuthException(String message, HttpStatus status, LocalDateTime localDateTime) {
		super();
		this.message = message;
		this.status = status;
		this.localDateTime = localDateTime;
	}

	public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }  
}
