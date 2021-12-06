package com.mybank.restservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mybank.restservice.component.Providers;
import com.mybank.restservice.controller.AuthenticationController;
import com.mybank.restservice.data.AuthRequestData;
import com.mybank.restservice.data.Results;
import com.mybank.restservice.dto.AuthResponseDTO;
import com.mybank.restservice.service.AuthenticationServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthenticationController.class)
public class AuthApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthenticationServiceImpl authenticationService;
    
    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testValidateAccountNumberSuccessWithProvider() throws Exception {

    	String[] prov = {"Provider1", "Provider2"};
    	
    	AuthRequestData authReqData = new AuthRequestData();
    	authReqData.setAccountNumber("1234");
    	authReqData.setProviders(new ArrayList(Arrays.asList(prov)));
    	
    	List<AuthResponseDTO> authRespDtoList = new ArrayList<>();
    	
    	AuthResponseDTO provider1 = new AuthResponseDTO("Provider1", true);
    	AuthResponseDTO provider2 = new AuthResponseDTO("Provider1", false);
    	
    	authRespDtoList.add(provider1);
    	authRespDtoList.add(provider2);
    	
    	Results result = new Results(authRespDtoList);
    	
    	
    	Mockito.when(authenticationService.validateAccount(authReqData)).thenReturn(authRespDtoList);
    	
    	
    	mockMvc.perform(post("/validate")
                .content(mapper.writeValueAsString(authReqData))
                .contentType(MediaType.APPLICATION_JSON))
    			.andExpect(jsonPath("$", Matchers.hasSize(2)))
    			.andExpect(jsonPath("$[0].provider", Matchers.is("Provider1")))
    			.andExpect(jsonPath("$[0].valid", Matchers.is(true)));;;
    	
    	
    	
    	
    }
}
