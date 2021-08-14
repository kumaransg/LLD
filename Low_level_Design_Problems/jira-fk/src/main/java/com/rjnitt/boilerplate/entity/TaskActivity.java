package com.rjnitt.boilerplate.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rjnitt.boilerplate.entity.Sprint.SprintBuilder;
import com.rjnitt.boilerplate.util.TaskStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder

@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"task"})
public class TaskActivity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	private Task task;
	
	@Enumerated(EnumType.STRING)
	private TaskStatus status;

	private String comment;

	private Long createdAt;

	private Long createdBy;

	private Boolean isActive;

	public static TaskActivity createNewFromTask(Task t) {
		TaskActivity ta = new TaskActivity();
		ta.setIsActive(true);
		ta.setComment(t.getTitle());
		ta.setStatus(t.getCurrentStatus());
		ta.setCreatedAt(t.getCreatedAt());
		ta.setCreatedBy(t.getCreatedBy());
		ta.setTask(t);
		return ta;
	}

}