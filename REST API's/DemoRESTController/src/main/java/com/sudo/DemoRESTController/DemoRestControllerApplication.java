package com.sudo.DemoRESTController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoRestControllerApplication {

	public static void main(String[] args)  {
		System.out.println("Server started!");
		SpringApplication.run(DemoRestControllerApplication.class, args);
	}

}
