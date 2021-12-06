package com.mybank.restservice;

import com.mybank.restservice.controller.AuthenticationController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AuthenticationApiSmokeTest {

    @Autowired
    AuthenticationController authenticationController;

    @Test
    void contextLoads() {
        assertThat(authenticationController).isNotNull();
    }
}
