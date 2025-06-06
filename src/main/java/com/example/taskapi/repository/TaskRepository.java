package com.example.taskapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.taskapi.model.Task;
import com.example.taskapi.model.TaskStatus;

public interface TaskRepository extends JpaRepository<Task, Long>{

	List<Task> findByStatus(TaskStatus status);
	
	List<Task> findByCompletedTrue();
	
	List<Task> findByCompletedFalse();
}
