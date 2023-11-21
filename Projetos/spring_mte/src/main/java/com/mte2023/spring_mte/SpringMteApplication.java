package com.mte2023.spring_mte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.mte2023.spring_mte.entities")
public class SpringMteApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMteApplication.class, args);
	}
}