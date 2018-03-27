package com.br.fontana.digital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class LojaSaoJoaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojaSaoJoaoApplication.class, args);
	}
	
	@RequestMapping("/home")
	public String hello() {
		return "Hello buddy!";
	}
}
