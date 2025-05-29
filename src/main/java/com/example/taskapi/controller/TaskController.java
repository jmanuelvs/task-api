package com.example.taskapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.taskapi.model.Task;
import com.example.taskapi.repository.TaskRepository;

@RestController
@RequestMapping("/tasks") //Ruta base del controlador
public class TaskController {
	
	private final TaskRepository taskRepository;
	
	//Inyeccion de dependenciass mediante constructor
	public TaskController(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	@GetMapping
	public List<Task> getAllTasks(){
		return taskRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Task createTask(@RequestBody Task task) {
		if(task.getTitle() == null || task.getTitle().trim().isEmpty()) {
			throw new IllegalArgumentException("El título es obligatorio");
		}
		return taskRepository.save(task);
	}
	
	@PutMapping("/{id}")
	public Task updateTask(@PathVariable Long id, @RequestBody Task updateTask) {
		Optional<Task> optionalTask = taskRepository.findById(id);
		
		if(optionalTask.isEmpty()) {
			throw new TaskNotFoundException("Tarea no encontrada con ID: " + id);
		}
		
		Task existingTask = optionalTask.get();
		
		//Actualizar solo campos permitidos
		existingTask.setTitle(updateTask.getTitle());
		existingTask.setDescription(updateTask.getDescription());
		existingTask.setCompleted(updateTask.isCompleted());
		
		return taskRepository.save(existingTask);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteTask(@PathVariable Long id) {
		if (!taskRepository.existsById(id)) {
			throw new TaskNotFoundException("Tarea no encontrada con ID: " + id);
		}
		taskRepository.deleteById(id);
	}
}
