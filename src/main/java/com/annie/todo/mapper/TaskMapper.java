package com.annie.todo.mapper;

import com.annie.todo.dto.*;
import com.annie.todo.entity.Task;

public class TaskMapper {
	
	public TaskResponseDTO mapToDTO(Task task) {
	    return new TaskResponseDTO(
	        task.getId(),
	        task.getTaskName(),
	        task.getDescription(),
	        task.getDueDate(),
	        task.getDone(),
	        task.getPriority()
	    );
	}
	
	public Task toEntity(TaskRequestDTO dto) {
        Task task = new Task();
        task.setTaskName(dto.getTaskName());
        task.setDescription(dto.getDescription());
        task.setDueDate(dto.getDueDate());
        task.setDone(dto.isDone());        
        task.setPriority(dto.getPriority());
        return task;
    }

}
