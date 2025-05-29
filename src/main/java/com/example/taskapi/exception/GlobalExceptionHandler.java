package com.example.taskapi.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.taskapi.controller.TaskNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	//Maneja excepciones especificas como TaskNotFoundException
	@ExceptionHandler(TaskNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleTaskNotFound(TaskNotFoundException ex){
		Map<String, Object> body = new HashMap<>();
		body.put("message", ex.getMessage());
		body.put("timestamp", LocalDateTime.now());
		body.put("status", HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
	
	//Maneja cualquier otra excepcion no controlada
	public ResponseEntity<Map<String, Object>> handleGeneralException(Exception ex){
		Map<String, Object> body = new HashMap<>();
		body.put("message", "Ocurrio un error interno: " + ex.getMessage());
		body.put("timestamp", LocalDateTime.now());
		body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		
		return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
