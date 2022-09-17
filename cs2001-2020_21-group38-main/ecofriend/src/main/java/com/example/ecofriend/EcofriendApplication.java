package com.example.ecofriend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EcofriendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcofriendApplication.class, args);
	}

}
