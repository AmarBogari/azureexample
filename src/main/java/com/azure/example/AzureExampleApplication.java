package com.azure.example;

import com.azure.example.config.MessageProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class AzureExampleApplication {

	@Value("${config1.message}")
	public String value1;

	@Value("${config.message}")
	public String value;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AzureExampleApplication.class, args);
		MessageProperties messageProperties = context.getBean(MessageProperties.class);
		log.info("datasource : {} dbdriverclass : {}", messageProperties.getDatasource() ,
				messageProperties.getDbdriverclass());
		log.info("dbusername : {}  dbpassword : {}",  messageProperties.getDbusername(),
				messageProperties.getDbpassword());

	}


}
