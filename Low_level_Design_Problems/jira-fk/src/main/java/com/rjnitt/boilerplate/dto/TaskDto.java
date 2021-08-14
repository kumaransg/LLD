package com.rjnitt.boilerplate.dto;

import com.rjnitt.boilerplate.util.IssueType;
import com.rjnitt.boilerplate.util.TaskStatus;
import com.rjnitt.boilerplate.util.Util;

import lombok.Data;

@Data
public class TaskDto {

	private Long id;

	private String title;

	private String description;

	private Long sprintId;

	private Long dueDate;

	private String taskStatus;

	private String issueType;

	private Long createdBy;

	private Long assigneeId;


	public void validateForUpdate() {
		validateTaskId();
		validateForCreate();
	}
	
	public void validateForCreate() {
		validateTitle();
		validateSprintId();
		validateDueDate();
		validateTaskStatus();
		validateIssueType();
		validateCreatedBy();
		validateAssignned();
	}

	private void validateAssignned() {
		Util.validateLong(assigneeId, "Assignned Id can't be null/empty");

	}

	private void validateCreatedBy() {
		Util.validateLong(createdBy, "created by not valid");
	}

	private void validateIssueType() {
		IssueType.validate(issueType);

	}

	private void validateTaskStatus() {
		TaskStatus.validate(taskStatus);

	}

	private void validateDueDate() {

		Util.validateLong(dueDate, "Due date not valid");
	}

	private void validateSprintId() {
		Util.validateLong(sprintId, "Due date not valid");
	}

	private void validateTitle() {
		Util.validateString(title, "Tasj Title can't be null/empty");

	}

	public void validateForDisbale() {

		validateTaskId();
	}

	private void validateTaskId() {
		Util.validateLong(id, "Task Id can't be null");

	}


}
