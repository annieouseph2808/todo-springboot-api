package com.annie.todo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import com.annie.todo.dto.*;
import com.annie.todo.service.TodoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/task")
@CrossOrigin(origins = "*")
public class TodoController {
	private TodoService _service;
	public TodoController(TodoService service) {
		this._service = service;
	}
	@PostMapping
	public TaskResponseDTO createTask(@Valid @RequestBody TaskRequestDTO dto) {
		return _service.createTask(dto);
	}
	// ✅ GET ALL TASKS
    @GetMapping
    public List<TaskResponseDTO> getAllTasks() {
        return _service.getAllTasks();
    }
}
