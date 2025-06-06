package com.example.taskapi.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "tasks")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Autoincremental
	private Long id;
	
	@NotBlank(message = "El título es obligatorio")
	private String title;
	
	@Size(max = 500,message = "La descripción no puede superar los 500 caracteres")//Limite a 500 caracteres
	private String description;
	
	private boolean completed;
	
	@FutureOrPresent(message = "La fecha límite debe ser hoy o posterior")
	private LocalDate dueDate;
	
	@Enumerated(EnumType.STRING)
	private TaskStatus status;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}
	
	
	
	

}
