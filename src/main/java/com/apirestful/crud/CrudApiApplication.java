package com.apirestful.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
		"com.apirestful.crud",
		"com.apirestful.crud.security", // Configurações de segurança
		"com.apirestful.crud.controller" // Controladores REST
})
@SpringBootApplication
public class CrudApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApiApplication.class, args);
	}

}
