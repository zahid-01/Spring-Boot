package com.sudo.thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThymeleafApplication {

	public static void main(String[] args) {
		System.out.println("Server Started");

		SpringApplication.run(ThymeleafApplication.class, args);
	}

}
