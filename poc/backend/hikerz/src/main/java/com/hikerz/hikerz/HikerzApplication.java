package com.hikerz.hikerz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.hikerz.hikerz")
@EnableJpaRepositories(basePackages = "com.hikerz.hikerz")
public class HikerzApplication {

	public static void main(String[] args) {
		SpringApplication.run(HikerzApplication.class, args);
	}

}
