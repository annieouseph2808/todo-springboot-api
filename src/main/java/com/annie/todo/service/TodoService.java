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
		Task saved = repository.save(task); //if id is null this is considered insert save
		return mapper.mapToDTO(saved);
	}
	
	public List<TaskResponseDTO> getAllTasks(){
		return repository.findAll().stream().map(mapper::mapToDTO).toList();
	}
	public void deleteTask(long Id) {
		Task task = repository.findById(Id).orElseThrow(() -> new RuntimeException("Task not found with id: " + Id));
		repository.delete(task);
	}
	
	public TaskResponseDTO getTaskById(Long Id) {
		Task task = repository.findById(Id).orElseThrow(() -> new RuntimeException("Task not found with id: " + Id));
		return mapper.mapToDTO(task);
	}
	
	public TaskResponseDTO updateTask(Long id, TaskRequestDTO dto) {

	    Task task = repository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));

	    task.setTaskName(dto.getTaskName());
	    task.setDescription(dto.getDescription());
	    task.setDueDate(dto.getDueDate());
	    task.setDone(dto.isDone());
	    task.setPriority(dto.getPriority());

	    Task updated = repository.save(task); //since id present this is updation

	    return mapper.mapToDTO(updated);
	}
}
