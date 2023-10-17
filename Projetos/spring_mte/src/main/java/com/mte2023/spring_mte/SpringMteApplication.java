package com.mte2023.spring_mte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mte2023.spring_mte.config.TestConfig;

@SpringBootApplication(scanBasePackages = "com.mte2023.spring_mte.entities")
public class SpringMteApplication extends TestConfig{
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMteApplication.class, args);
	}

}