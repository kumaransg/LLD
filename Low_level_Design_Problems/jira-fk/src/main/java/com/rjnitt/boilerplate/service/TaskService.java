package com.rjnitt.boilerplate.service;

import java.util.List;
import java.util.Map;

import com.rjnitt.boilerplate.dto.TaskDetailDto;
import com.rjnitt.boilerplate.dto.TaskDto;
import com.rjnitt.boilerplate.entity.Task;
import com.rjnitt.boilerplate.util.IssueType;
import com.rjnitt.boilerplate.util.TaskStatus;

public interface TaskService {

	Map<TaskStatus, List<Task>> getDashboard(Long sprintId);

	TaskDetailDto getTaskDetail(Long taskId);

	List<Task> getDelayTask(Long sprintId);

	List<Task> getAssignTask(Long userId);

	Task createTask(TaskDto task);
	
	Task updateTask(TaskDto task);

	Boolean disableTask(TaskDto task);
	
	List<Task> getDisableTask(Long sprintId);
	
	
	
}
