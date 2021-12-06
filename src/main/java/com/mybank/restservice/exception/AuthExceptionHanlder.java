package com.mybank.restservice.exception;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AuthExceptionHanlder {

	@ExceptionHandler(value = {AuthRequestException.class})
    public ResponseEntity<Object> handleAuthReqException(AuthRequestException authRequestException){
        AuthException authException = new AuthException(authRequestException.getMessage(),
        		HttpStatus.BAD_REQUEST,
        		LocalDateTime.now());
        
        return new ResponseEntity<>(authException, HttpStatus.BAD_REQUEST);
    }
}
