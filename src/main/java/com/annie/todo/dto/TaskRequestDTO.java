package com.annie.todo.dto;

import java.time.LocalDate;

import com.annie.todo.enums.Priority;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
public class TaskRequestDTO {
	
	@NotBlank(message = "Task name is required")
	private String taskName;
	
	private String description;
	
	 @FutureOrPresent(message = "Due date cannot be in the past")
	private LocalDate dueDate;
	 
	private boolean done;
	
	@NotNull(message = "Priority is required")
	private Priority priority;
	
	public TaskRequestDTO(String taskName, String description, LocalDate dueDate, Boolean done, Priority priority) {
        this.taskName = taskName;
        this.description = description;
        this.dueDate = dueDate;
        this.done = done;
        this.priority = priority;
    }
}
