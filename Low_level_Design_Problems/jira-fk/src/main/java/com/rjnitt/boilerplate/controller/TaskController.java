package com.rjnitt.boilerplate.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rjnitt.boilerplate.dto.TaskDetailDto;
import com.rjnitt.boilerplate.dto.TaskDto;
import com.rjnitt.boilerplate.entity.Task;
import com.rjnitt.boilerplate.service.TaskService;
import com.rjnitt.boilerplate.util.TaskStatus;

@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@PostMapping(value = "/create")
	public Task create(@RequestBody TaskDto taskdto) {
		return taskService.createTask(taskdto);
	}

	@PostMapping(value = "/update")
	public Task update(@RequestBody TaskDto taskdto) {
		return taskService.updateTask(taskdto);
	}

	@PostMapping(value = "/disable")
	public Boolean disable(@RequestBody TaskDto taskdto) {
		return taskService.disableTask(taskdto);
	}

	@GetMapping(value = "/get-detail")
	public TaskDetailDto getTaskDetail(@RequestParam Long taskId) {
		return taskService.getTaskDetail(taskId);
	}

	@GetMapping(value = "/dashboard")
	public Map<TaskStatus, List<Task>> getDashboard(@RequestParam Long sprintId) {
		return taskService.getDashboard(sprintId);
	}

	@GetMapping(value = "/delay")
	public List<Task> getDelayTask(@RequestParam Long sprintId) {
		return taskService.getDelayTask(sprintId);
	}

	@GetMapping(value = "/assign")
	public List<Task> getAssignTask(@RequestParam Long userId) {
		return taskService.getAssignTask(userId);
	}

	@GetMapping(value = "/disable-task")
	public List<Task> getDisableTask(@RequestParam Long sprintId) {
		return taskService.getDisableTask(sprintId);
	}

}
