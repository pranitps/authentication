package com.mybank.restservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mybank.restservice.controller.AuthenticationController;
import com.mybank.restservice.data.AuthRequestData;
import com.mybank.restservice.exception.AuthRequestException;
import com.mybank.restservice.service.AuthenticationServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;


@WebMvcTest(AuthenticationController.class)
public class AuthApiValidationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthenticationServiceImpl authenticationService;

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testInvalidAccountNumber() throws Exception{
        AuthRequestData authRequestData = new AuthRequestData();
        authRequestData.setAccountNumber(null);
        authRequestData.setProviders(null);

        mockMvc.perform(post("/validate")
                .content(mapper.writeValueAsString(authRequestData))
                .contentType(MediaType.APPLICATION_JSON))
        		.andExpect(result -> assertThat(result.getResolvedException() instanceof AuthRequestException));
    }

    @Test
    public void testAccountNumberSuccess() throws Exception{
        AuthRequestData authRequestData = new AuthRequestData();
        authRequestData.setAccountNumber("1234");
        authRequestData.setProviders(new ArrayList<>(Arrays.asList("Provider1", "Provider2")));

        mockMvc.perform(post("/validate")
                .content(mapper.writeValueAsString(authRequestData))
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void testValidAcctNumWithNoProviders() throws Exception{
        AuthRequestData authRequestData = new AuthRequestData();
        authRequestData.setAccountNumber("1234");
        authRequestData.setProviders(null);

        mockMvc.perform(post("/validate")
                .content(mapper.writeValueAsString(authRequestData))
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }
}
