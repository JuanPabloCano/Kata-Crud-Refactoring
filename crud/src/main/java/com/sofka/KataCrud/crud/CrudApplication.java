package com.sofka.KataCrud.crud;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudApplication {

	// Creación de spring Bean del ModelMapper
	@Bean
	public ModelMapper todoMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

}
