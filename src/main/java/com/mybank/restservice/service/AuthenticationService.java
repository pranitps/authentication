package com.mybank.restservice.service;

import com.mybank.restservice.data.AuthRequestData;
import com.mybank.restservice.dto.AuthResponseDTO;
import com.mybank.restservice.exception.AuthRequestException;

import java.util.List;
import java.util.Optional;

/**
 * Add java doc for this class
 *
 * @author Kyra Solutions Inc.
 * @version 1.0
 * @since 12/4/2021.
 */
public interface AuthenticationService {

    public List<AuthResponseDTO> validateAccount(final AuthRequestData authenticationData) throws AuthRequestException;
}
