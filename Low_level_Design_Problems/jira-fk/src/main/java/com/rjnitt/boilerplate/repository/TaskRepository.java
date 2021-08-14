package com.rjnitt.boilerplate.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rjnitt.boilerplate.entity.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {

	@Modifying
	@Transactional
	@Query(value = "update task set is_active=0, created_by=?3, created_at=?2 where id=?1", nativeQuery = true)
	void disable(Long id, Long ct, Long userid);

	@Query(value = "select * from task where is_active=0 and sprint_id=?1 ", nativeQuery = true)
	List<Task> getDisableTask(Long sprintId);

	@Query(value = "select * from task where is_active=1 and assignee_id=?1 ", nativeQuery = true)
	List<Task> getAssignTask(Long userId);

	@Query(value = "select * from task where is_active=1 and sprint_id=?1 and due_date < ?2 ", nativeQuery = true)
	List<Task> getDelayTask(Long sprintId, Long ct);
	
	@Query(value = "select * from task where is_active=1 and sprint_id=?1 ", nativeQuery = true)
	List<Task> getAllTask(Long sprintId);

}