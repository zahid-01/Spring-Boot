package com.zahid.springboot.coolApp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoolAppApplication {
	@Value("${owner.port}")
	static String port;

	public static void main(String[] args) {
		System.out.println("Server Started at port " + port);
		SpringApplication.run(CoolAppApplication.class, args);
	}


}
