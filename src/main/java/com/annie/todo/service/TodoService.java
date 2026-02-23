package com.annie.todo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.annie.todo.dto.*;
import com.annie.todo.entity.Task;
import com.annie.todo.mapper.TaskMapper;
import com.annie.todo.repository.TodoRepository;

@Service
public class TodoService {
	private final TodoRepository repository;
	private final TaskMapper mapper;
	
	public TodoService(TodoRepository repository) {
		this.repository = repository;
        this.mapper = new TaskMapper();
	}
	
	public TaskResponseDTO createTask(TaskRequestDTO dto) {
		Task task = mapper.toEntity(dto);
		Task saved = repository.save(task);
		return mapper.mapToDTO(saved);
	}
	
	public List<TaskResponseDTO> getAllTasks(){
		return repository.findAll().stream().map(mapper::mapToDTO).toList();
	}
}
