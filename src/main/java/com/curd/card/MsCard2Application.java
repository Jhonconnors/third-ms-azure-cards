package com.curd.card;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/test")
public class MsCard2Application {
	
	@GetMapping
	public String saludo() {
		return "Prueba de conexion Azure";
	}

	public static void main(String[] args) {
		SpringApplication.run(MsCard2Application.class, args);
	}

}
