package com.example.ecofriend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@SpringBootApplication
@EnableJpaAuditing
public class EcofriendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcofriendApplication.class, args);
	}
	

	@Bean
	    public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurerAdapter() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/restaurants/mostdonation").allowedOrigins("http://127.0.0.1:5500");
	                registry.addMapping("/add/donations/{restaurantId}").allowedOrigins("http://127.0.0.1:5500");
	                registry.addMapping("/restaurant/{name}").allowedOrigins("http://127.0.0.1:5500");
	                registry.addMapping("/api/restaurants/add/restaurant").allowedOrigins("http://127.0.0.1:5500");
	               
	            }
	        };
	    }


}
