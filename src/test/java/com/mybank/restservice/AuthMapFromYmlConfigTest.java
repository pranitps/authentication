package com.mybank.restservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mybank.restservice.component.Providers;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AuthMapFromYmlConfigTest {

	@Autowired
    private Providers providers;
	
	@Test
    public void testYmlFileInjection() {
        assertThat(providers.getProviders()).hasSize(2);
    }
}
