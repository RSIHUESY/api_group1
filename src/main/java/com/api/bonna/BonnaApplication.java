package com.api.bonna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class BonnaApplication {
	public static void main(String[] args) {
		SpringApplication.run(BonnaApplication.class, args);
	}
}
