package com.example.copsboot;

import java.util.UUID;

import com.example.copsboot.orm.jpa.InMemoryUniqueIdGenerator;
import com.example.copsboot.orm.jpa.UniqueIdGenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CopsbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(CopsbootApplication.class, args);
	}

	@Bean
	public UniqueIdGenerator<UUID> generator() {
		return new InMemoryUniqueIdGenerator();
	}

}
