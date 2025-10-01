package com.hikerzactivity.hikerzactivity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.hikerzactivity.hikerzactivity")
@EnableJpaRepositories(basePackages = "com.hikerzactivity.hikerzactivity")
public class HikerzActivityApplication {

	public static void main(String[] args) {
		SpringApplication.run(HikerzActivityApplication.class, args);
	}

}
