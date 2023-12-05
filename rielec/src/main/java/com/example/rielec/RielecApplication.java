package com.example.rielec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RielecApplication {

	public static void main(String[] args) {
		SpringApplication.run(RielecApplication.class, args);
	}

}
