package com.example.taskapi.controller;

public class TaskNotFoundException extends RuntimeException{
	public TaskNotFoundException(String message) {
		super(message);
	}

}
