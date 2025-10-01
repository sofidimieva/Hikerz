package com.hikerzuser.hikerzuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.hikerzuser.hikerzuser")
@EnableJpaRepositories(basePackages = "com.hikerzuser.hikerzuser")
public class HikerzUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(HikerzUserApplication.class, args);
	}

}
