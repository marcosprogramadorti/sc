package br.com.ad.sc.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class ScApiApplication4 {

	public static void main(String[] args) {
		SpringApplication.run(ScApiApplication4.class, args);
	}
	
	@RequestMapping("/home")
	public String hello() {
		return "Ola!";
	}
	
}
