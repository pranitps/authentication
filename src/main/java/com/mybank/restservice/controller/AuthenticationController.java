package com.mybank.restservice.controller;

import java.util.Optional;

import org.junit.platform.commons.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mybank.restservice.data.AuthRequestData;
import com.mybank.restservice.data.Results;
import com.mybank.restservice.exception.AuthRequestException;
import com.mybank.restservice.service.AuthenticationServiceImpl;

@RestController
public class AuthenticationController {

	Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

	@Autowired
	private AuthenticationServiceImpl authenticationService;

	@PostMapping(value = "/validate", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Results validateAccountNumber(@RequestBody AuthRequestData authenticationData) {
		logger.info("Received request: " + authenticationData.toString());

		Results results = null;
		if (authenticationData != null && StringUtils.isBlank(authenticationData.getAccountNumber())) {
			logger.info("Validation failed: Invalid account number.");
			throw new AuthRequestException("Invalid input parameter");
		} else {

			results = new Results(authenticationService.validateAccount(authenticationData));
			logger.info("Response: " + results.toString());
		}
		return results;
	}

}
