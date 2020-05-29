package com.azure.example.config;

import com.azure.data.appconfiguration.ConfigurationClient;
import com.azure.data.appconfiguration.ConfigurationClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class AzureConfiguration {

   @Value("${connection.string}")
   private String connectionString;

    @Bean
    public ConfigurationClient configurationClient(){
        return new ConfigurationClientBuilder().connectionString(connectionString).buildClient();
    }
}

