package com.azure.example.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "azure.config")
@Data
public class MessageProperties {

    private String datasource;
    private String dbdriverclass;
    private String dbusername;
    private String dbpassword;
}
