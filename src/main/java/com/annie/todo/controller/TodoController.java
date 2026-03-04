package com.annie.todo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.annie.todo.dto.*;
import com.annie.todo.service.TodoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/task")
@CrossOrigin(origins = "http://localhost:4200")
public class TodoController {
	private TodoService _service;
	public TodoController(TodoService service) {
		this._service = service;
	}
	@PostMapping
	public TaskResponseDTO createTask(@Valid @RequestBody TaskRequestDTO dto) {
		return _service.createTask(dto);
	}
    @GetMapping
    public List<TaskResponseDTO> getAllTasks() {
        return _service.getAllTasks();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        _service.deleteTask(id);
        return ResponseEntity.ok("Task deleted successfully");
    }
    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> updateTask(
            @PathVariable Long id,
            @RequestBody TaskRequestDTO dto) {
        return ResponseEntity.ok(_service.updateTask(id, dto));
    }
}
