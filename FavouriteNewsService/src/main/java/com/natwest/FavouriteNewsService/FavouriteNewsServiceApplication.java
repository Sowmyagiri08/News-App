package com.natwest.FavouriteNewsService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableDiscoveryClient
@SpringBootApplication
public class FavouriteNewsServiceApplication {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/v1/auth/*").allowedOrigins("http://localhost:9100","http://localhost:4200","http://localhost:8080");
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(FavouriteNewsServiceApplication.class, args);
	}

}
