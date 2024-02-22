package com.prueba.logisticaPrueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class LogisticaPruebaApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(LogisticaPruebaApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LogisticaPruebaApplication.class);
	}

}
