package com.rjnitt.boilerplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rjnitt.boilerplate.dto.SprintDto;
import com.rjnitt.boilerplate.entity.Sprint;
import com.rjnitt.boilerplate.service.SprintService;

@RestController
@RequestMapping("/sprint")
public class SprintController {

	@Autowired
	private SprintService sprintService;
	

	@PostMapping(value = "/create")
	public Sprint create(@RequestBody SprintDto sprint) {
		return sprintService.createSprint(sprint);
	}

	@GetMapping(value = "/get")
	public Sprint get(@RequestParam Long sprintId) {
		return sprintService.get(sprintId);
	}

}
