package com.spa.projet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.spa.projet")
public class projetApplication {

	public static void main(String[] args) {
		SpringApplication.run(projetApplication.class, args);
	}

}
