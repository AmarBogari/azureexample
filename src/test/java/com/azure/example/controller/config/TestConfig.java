package com.azure.example.controller.config;
import com.azure.data.appconfiguration.ConfigurationClient;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;

@TestConfiguration
public class TestConfig {

    @MockBean
    ConfigurationClient configurationClient;


}
