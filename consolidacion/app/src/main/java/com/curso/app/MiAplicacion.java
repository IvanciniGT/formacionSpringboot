package com.curso.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages= {"com.curso.app"})	// Me encuentra los Repositorios en los .jar 
@EntityScan(basePackages= {"com.curso.app"})			// Me encuentra las Entidades en los .jar 
@ComponentScan(basePackages= {"com.curso.app"})		    // Me encuentra los servicios/apisRest/configruaciones en los .jar 
public class MiAplicacion {

	public static void main(String[] args) {
		SpringApplication.run(MiAplicacion.class, args); // Inversión de control
	}
	
}
