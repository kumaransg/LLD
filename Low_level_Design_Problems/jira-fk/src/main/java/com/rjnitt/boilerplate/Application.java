package com.rjnitt.boilerplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.*;


@Controller
@SpringBootApplication
@EnableAsync

public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
