package com.spring.page;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MiniProjectPageApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniProjectPageApplication.class, args);
	}

}
