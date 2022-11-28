package com.esg.esgdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.esg.esgdata")
@EnableAutoConfiguration
public class EsgDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsgDataApplication.class, args);
	}

}
