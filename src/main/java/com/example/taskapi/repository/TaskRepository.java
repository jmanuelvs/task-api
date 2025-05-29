package com.example.taskapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.taskapi.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
