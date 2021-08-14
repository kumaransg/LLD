package com.rjnitt.boilerplate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.rjnitt.boilerplate.dto.SprintDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder

@NoArgsConstructor
@AllArgsConstructor
public class Sprint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private Long createdAt;

	private Long createdBy;

	private Boolean isActive;

	public static Sprint tranformForCreate(SprintDto task, Long ct, Long userId) {
		Sprint s = new Sprint();
		s.setIsActive(true);
		s.setCreatedAt(ct);
		s.setCreatedBy(userId);
		s.setName(task.getName());
		return s;
	}

}