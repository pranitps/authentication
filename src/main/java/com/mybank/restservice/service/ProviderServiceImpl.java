package com.mybank.restservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.mybank.restservice.component.Provider;
import com.mybank.restservice.dto.PostDTO;
import com.mybank.restservice.dto.ResponseDTO;

import reactor.core.publisher.Mono;

@Service
public class ProviderServiceImpl implements ProviderService {

    /*@Autowired
    private WebClient provider1ApiClient;
    
    @Autowired
    private WebClient provider2ApiClient;*/

    @Autowired
    private RestTemplate restTemplate;
    
    @Override
	public ResponseDTO validateAccountNumber(PostDTO postDTO, Provider provider) {
    	//ResponseDTO responseDTO = restTemplate.getForObject(provider.getUrl(), ResponseDTO.class, postDTO);
    	return new ResponseDTO(postDTO.getAccountNumber().chars().allMatch(Character::isDigit));
    	
	}

	/*@Override
    public Mono<ResponseDTO> validateProv1AccountNum(PostDTO postDTO) {

        return provider1ApiClient
                .post()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(postDTO), PostDTO.class)
                .retrieve()
                .bodyToMono(ResponseDTO.class);
    }
    
    @Override
    public Mono<ResponseDTO> validateProv2AccountNum(PostDTO postDTO) {

        return provider2ApiClient
                .post()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(postDTO), PostDTO.class)
                .retrieve()
                .bodyToMono(ResponseDTO.class);
    }*/
}
