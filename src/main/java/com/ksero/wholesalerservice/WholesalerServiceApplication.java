package com.ksero.wholesalerservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@OpenAPIDefinition
@EnableJpaAuditing
@SpringBootApplication
public class WholesalerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WholesalerServiceApplication.class, args);
	}

}
