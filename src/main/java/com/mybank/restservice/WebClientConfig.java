package com.mybank.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.reactive.function.client.WebClient;

import com.mybank.restservice.component.Providers;

@ComponentScan
public class WebClientConfig {
	
	@Autowired
    private Providers providers;
	
	@Bean
	public WebClient provider1ApiClient(WebClient.Builder webClientBuilder) {
		return webClientBuilder.baseUrl(providers.getProviders().stream().filter(p -> p.getName().equals("provider1")).findFirst().get().getUrl()).build();
	}

	@Bean
	public WebClient provider2ApiClient(WebClient.Builder webClientBuilder) {
		return webClientBuilder.baseUrl(providers.getProviders().stream().filter(p -> p.getName().equals("provider2")).findFirst().get().getUrl()).build();
	}

}
