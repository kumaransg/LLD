package com.rjnitt.boilerplate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping(value = "/healthcheck")
	public String healthcheck() {

		return "service healthcheck is running";
	}

}
