package com.sudo.componentScanning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {"java.Util","java.com.sudo.componentScanning"}
)
public class ComponentScanningApplication {

	public static void main(String[] args)  {
		SpringApplication.run(ComponentScanningApplication.class, args);
	}

}
