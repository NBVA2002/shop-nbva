package com.nbva.authenticate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.nbva")
@SpringBootApplication(scanBasePackages = {"com.nbva"})
public class AuthenticateServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticateServiceApplication.class, args);
	}

}
