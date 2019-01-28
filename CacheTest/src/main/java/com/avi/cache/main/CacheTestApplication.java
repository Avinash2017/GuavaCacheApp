package com.avi.cache.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"com.avi.cache.*"})
@EnableJpaRepositories(basePackages = { "com.avi.cache.repo" })
@EntityScan(basePackages={"com.avi.cache.model"})
public class CacheTestApplication {
	public static void main(String[] args) {
		SpringApplication.run(CacheTestApplication.class, args);
	}

}

