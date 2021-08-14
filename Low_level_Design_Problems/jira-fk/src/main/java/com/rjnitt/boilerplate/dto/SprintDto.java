package com.rjnitt.boilerplate.dto;

import com.rjnitt.boilerplate.util.Util;

import lombok.Data;

@Data
public class SprintDto {

	private Long id;
	private String name;

	public void validateForCreate() {
		validateName();

	}

	private void validateName() {
		Util.validateString("Name", "Sprint Name can't be null/empty");

	}
}
