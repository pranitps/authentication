package com.mybank.restservice.service;

import com.mybank.restservice.component.Provider;
import com.mybank.restservice.dto.PostDTO;
import com.mybank.restservice.dto.ResponseDTO;

import reactor.core.publisher.Mono;

public interface ProviderService {

	ResponseDTO validateAccountNumber(PostDTO postDTO, Provider provider);
	
    /*Mono<ResponseDTO> validateProv1AccountNum(PostDTO postDTO);
    
    Mono<ResponseDTO> validateProv2AccountNum(PostDTO postDTO);*/
}
