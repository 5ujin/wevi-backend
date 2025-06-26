package com.wevi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WeviApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeviApplication.class, args);
	}

}
