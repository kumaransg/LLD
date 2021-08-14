package com.rjnitt.boilerplate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rjnitt.boilerplate.entity.TaskActivity;

public interface TaskActivityRepository extends CrudRepository<TaskActivity, Long> {

	@Query(value = "select * from task_activity where is_active=1 and task_id=?1", nativeQuery = true)
	List<TaskActivity> getByTaskId(Long taskId);

}