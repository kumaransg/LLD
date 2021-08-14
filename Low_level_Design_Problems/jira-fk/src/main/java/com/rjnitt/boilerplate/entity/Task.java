package com.rjnitt.boilerplate.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.rjnitt.boilerplate.dto.TaskDto;
import com.rjnitt.boilerplate.util.IssueType;
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
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String description;

	private Long dueDate;
	private Long assigneeId;

	@Enumerated(EnumType.STRING)
	private TaskStatus currentStatus;

	@Enumerated(EnumType.STRING)
	private IssueType issueType;

	private Long createdAt;

	private Long createdBy;

	private Boolean isActive;

	@OneToOne
	private Sprint sprint;

	public void transformForCreation(TaskDto taskdto, Long ct, Long userId) {
		this.setIsActive(true);
		this.setAssigneeId(taskdto.getAssigneeId());
		this.setCreatedAt(ct);
		this.setCreatedBy(userId);
		this.setCurrentStatus(TaskStatus.valueOf(taskdto.getTaskStatus()));
		this.setDescription(taskdto.getDescription());
		this.setDueDate(taskdto.getDueDate());
		this.setIssueType(IssueType.valueOf(taskdto.getIssueType()));
		Sprint sprintId = Sprint.builder().id(taskdto.getSprintId()).build();
		this.setSprint(sprintId);
		this.setTitle(taskdto.getTitle());
	}

	public void transformForUpdate(TaskDto taskdto, Long ct, Long userId) {
		this.setAssigneeId(taskdto.getAssigneeId());
		this.setCurrentStatus(TaskStatus.valueOf(taskdto.getTaskStatus()));
		this.setDescription(taskdto.getDescription());
		this.setDueDate(taskdto.getDueDate());
		this.setIssueType(IssueType.valueOf(taskdto.getIssueType()));
		this.setTitle(taskdto.getTitle());
	}

}