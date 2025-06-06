package com.example.taskapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.taskapi.model.Task;
import com.example.taskapi.model.TaskStatus;
import com.example.taskapi.repository.TaskRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks") //Ruta base del controlador
@Tag(name = "Tareas", description = "Operaciones relacionadas con la gestion de tareas")
public class TaskController {
	
	private final TaskRepository taskRepository;
	
	//Inyeccion de dependenciass mediante constructor
	public TaskController(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	@GetMapping
	@Operation(summary = "Obtiene todas las tareas", description = "Devuelve una lista de todas las tareas almacenadas")
	public List<Task> getAllTasks(@Parameter(description = "Filtrar por estado: PENDIENTE, EN_PROGRESO, COMPLETADA") @RequestParam(required = false) TaskStatus status){
		if(status == null) {
			return taskRepository.findAll();
		}else {
			return taskRepository.findByStatus(status);
		}
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(summary = "Crea una nueva tarea", description = "Guarda una nueva tarea en la base de datos")
    @ApiResponse(responseCode = "201", description = "Tarea creada exitosamente", content = @Content(schema = @Schema(implementation = Task.class)))
	public Task createTask(@Valid @RequestBody Task task) {
		return taskRepository.save(task);
	}
	
	@GetMapping("/{id}")
    @Operation(summary = "Obtiene una tarea por ID", description = "Devuelve una tarea específica según su identificador")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return taskRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new TaskNotFoundException("Tarea no encontrada con ID: " + id));
    }
	
	
	@PutMapping("/{id}")
	@Operation(summary = "Actualiza una tarea existente", description = "Reemplaza los datos de una tarea existente")
	public Task updateTask(@PathVariable Long id,@Valid @RequestBody Task updateTask) {
		Optional<Task> optionalTask = taskRepository.findById(id);
		
		if(optionalTask.isEmpty()) {
			throw new TaskNotFoundException("Tarea no encontrada con ID: " + id);
		}
		
		Task existingTask = optionalTask.get();
		
		//Actualizar solo campos permitidos
		existingTask.setTitle(updateTask.getTitle());
		existingTask.setDescription(updateTask.getDescription());
		existingTask.setCompleted(updateTask.isCompleted());
		existingTask.setDueDate(updateTask.getDueDate());
		existingTask.setStatus(updateTask.getStatus());
		
		return taskRepository.save(existingTask);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@Operation(summary = "Elimina una tarea", description = "Borra una tarea de la base de datos")
	public void deleteTask(@PathVariable Long id) {
		if (!taskRepository.existsById(id)) {
			throw new TaskNotFoundException("Tarea no encontrada con ID: " + id);
		}
		taskRepository.deleteById(id);
	}
	
	@GetMapping("/completed")
	public List<Task> getCompletedTask(){
		return taskRepository.findByCompletedTrue();
	}
	
	@GetMapping("/incomplete")
	public List<Task> getIncompletedTask(){
		return taskRepository.findByCompletedFalse();
	}
	
}
