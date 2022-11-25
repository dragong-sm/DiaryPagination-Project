package com.spring.page;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaAuditing
@SpringBootApplication
@EnableJpaRepositories
public class MiniProjectPageApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniProjectPageApplication.class, args);
	}

}
