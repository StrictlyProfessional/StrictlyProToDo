package com.revature.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan("com.revature")
@EnableJpaRepositories("com.revature.repos")
@EntityScan("com.revature.beans")
public class StrictlyProToDoApplication {

	public static void main(String[] args) {
		SpringApplication.run(StrictlyProToDoApplication.class, args);
		
		
	}

}
