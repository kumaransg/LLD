package com.rjnitt.boilerplate.dto;

import java.util.List;

import com.rjnitt.boilerplate.entity.Task;
import com.rjnitt.boilerplate.entity.TaskActivity;

import lombok.Data;

@Data
public class TaskDetailDto {
	
	
	private Task task;
	
	private List<TaskActivity> taskActivity;

	public static TaskDetailDto tranformForDetail(Task tt, List<TaskActivity> l) {
		TaskDetailDto tdd = new TaskDetailDto();
		tdd.setTask(tt);;
		tdd.setTaskActivity(l);
		return tdd;
	}
	

}
