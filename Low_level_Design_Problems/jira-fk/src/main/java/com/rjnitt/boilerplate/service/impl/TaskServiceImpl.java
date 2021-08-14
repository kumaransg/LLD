package com.rjnitt.boilerplate.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rjnitt.boilerplate.dto.TaskDetailDto;
import com.rjnitt.boilerplate.dto.TaskDto;
import com.rjnitt.boilerplate.entity.Task;
import com.rjnitt.boilerplate.entity.TaskActivity;
import com.rjnitt.boilerplate.repository.TaskActivityRepository;
import com.rjnitt.boilerplate.repository.TaskRepository;
import com.rjnitt.boilerplate.service.TaskService;
import com.rjnitt.boilerplate.util.CommonConstant;
import com.rjnitt.boilerplate.util.IssueType;
import com.rjnitt.boilerplate.util.TaskStatus;
import com.rjnitt.boilerplate.util.Util;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

	private final static Logger LOG = LoggerFactory.getLogger(TaskServiceImpl.class);
	
	@Autowired
	private TaskRepository taskRepo;

	@Autowired
	private TaskActivityRepository taskActRepo;

	@Override
	public Map<TaskStatus, List<Task>> getDashboard(Long sprintId) {
		LOG.info("getDashboard called for sprintId Id: [{}]", sprintId);
		Util.validateLong(sprintId, "Sprint Id can't be null/empty");
		Long ct = System.currentTimeMillis();
		List<Task> allTask = taskRepo.getAllTask(sprintId);
		Util.noRecordFoundForList(allTask);
		Map<TaskStatus, List<Task>> collect = allTask.stream().collect(Collectors.groupingBy(i->i.getCurrentStatus()));
		return collect;
	}

	@Override
	public TaskDetailDto getTaskDetail(Long taskId) {
		LOG.info("getTaskDetail called for task Id: [{}]", taskId);
		Util.validateLong(taskId, "Task Id can't be null/empty");
		Task tt = taskRepo.findOne(taskId);
		Util.noRecordFound(tt);
		List<TaskActivity> l = taskActRepo.getByTaskId(taskId);
		TaskDetailDto tdd = TaskDetailDto.tranformForDetail(tt, l);
		return tdd;
	}

	@Override
	public List<Task> getDelayTask(Long sprintId) {
		LOG.info("getDelayTask called for sprintId Id: [{}]", sprintId);
		Util.validateLong(sprintId, "Sprint Id can't be null/empty");
		Long ct = System.currentTimeMillis();
		List<Task> delaytask = taskRepo.getDelayTask(sprintId, ct);
		return Util.noRecordFoundForList(delaytask);
	}

	@Override
	public List<Task> getAssignTask(Long userId) {
		LOG.info("getAssignTask called for User Id: [{}]", userId);
		Util.validateLong(userId, "Assign Id can't be null/empty");
		List<Task> disableTasks = taskRepo.getAssignTask(userId);
		return Util.noRecordFoundForList(disableTasks);
	}

	@Override
	public Task createTask(TaskDto taskdto) {
		LOG.info("createTask called: [{}]", taskdto);
		taskdto.validateForCreate();
		Long ct = System.currentTimeMillis();
		Long userId = CommonConstant.UserId;
		Task task = new Task();
		task.transformForCreation(taskdto,ct,userId);
		Task save = taskRepo.save(task);
		
		TaskActivity ta = TaskActivity.createNewFromTask(task);
		taskActRepo.save(ta);
		
		return save;
	}

	@Override
	public Task updateTask(TaskDto taskdto) {
		LOG.info("updateTask called: [{}]", taskdto);
		taskdto.validateForUpdate();
		Long ct = System.currentTimeMillis();
		Long userId = CommonConstant.UserId;
		Task task = taskRepo.findOne(taskdto.getId());
		task.transformForUpdate(taskdto, ct, userId);
		Task save = taskRepo.save(task);
		return save;
	}

	@Override
	public Boolean disableTask(TaskDto taskdto) {
		LOG.info("disableTask called: [{}]", taskdto);
		taskdto.validateForDisbale();
		Long ct = System.currentTimeMillis();
		taskRepo.disable(taskdto.getId(), ct, CommonConstant.UserId);
		return true;
	}

	@Override
	public List<Task> getDisableTask(Long sprintId) {
		LOG.info("getDisableTask called for sprint Id: [{}]", sprintId);
		Util.validateLong(sprintId, "Sprint Id can't be null/empty");
		List<Task> disableTasks = taskRepo.getDisableTask(sprintId);
		return Util.noRecordFoundForList(disableTasks);
	}

}
