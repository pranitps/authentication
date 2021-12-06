package com.mybank.restservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybank.restservice.component.Provider;
import com.mybank.restservice.component.Providers;
import com.mybank.restservice.data.AuthRequestData;
import com.mybank.restservice.dto.AuthResponseDTO;
import com.mybank.restservice.dto.PostDTO;
import com.mybank.restservice.dto.ResponseDTO;
import com.mybank.restservice.exception.AuthRequestException;

import reactor.core.publisher.Mono;

@Service
public class AuthenticationServiceImpl {

	@Autowired
	private ProviderServiceImpl providerService;

	@Autowired
	private Providers providers;

	public List<AuthResponseDTO> validateAccount(final AuthRequestData authenticationData) throws AuthRequestException {
		List<AuthResponseDTO> authenticationDTOList = null;

		if (authenticationData.getProviders() != null && authenticationData.getProviders().size() != 0) {
			List<Provider> providerList = getProviderList(authenticationData);
			authenticationDTOList = processRestTemplate(authenticationData.getAccountNumber(), providerList);
		} else {
			authenticationDTOList = processRestTemplate(authenticationData.getAccountNumber(),
					providers.getProviders());
		}

		return authenticationDTOList;
	}

	private List<Provider> getProviderList(final AuthRequestData authenticationData) {
		return providers.getProviders().stream()
				.filter(configProv -> authenticationData.getProviders().stream()
						.anyMatch(reqProv -> reqProv.equalsIgnoreCase(configProv.getName())))
				.collect(Collectors.toList());
	}

	private List<AuthResponseDTO> processRestTemplate(final String accountNumber, final List<Provider> providerList) {

		List<AuthResponseDTO> authenticationDTOList = new ArrayList<>();
		PostDTO postDTO = new PostDTO(accountNumber);

		providerList.stream().forEach(provider -> {
			final AuthResponseDTO authResponseDTO = new AuthResponseDTO(provider.getName(), 
					(providerService.validateAccountNumber(postDTO, provider)).isValid());
			authenticationDTOList.add(authResponseDTO);
		});
		return authenticationDTOList;
	}

	/*private List<AuthResponseDTO> processFluxRestTemplate(final String accountNumber,
			final List<Provider> providerList) {

		List<AuthResponseDTO> authenticationDTOList = new ArrayList<>();

		PostDTO postDTO = new PostDTO(accountNumber);

		Mono<ResponseDTO> provider1Response = providerService.validateProv1AccountNum(postDTO);
		Mono<ResponseDTO> provider2Response = providerService.validateProv2AccountNum(postDTO);

		return authenticationDTOList;
	}*/
}
