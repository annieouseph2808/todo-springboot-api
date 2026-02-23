package com.annie.todo.dto;

import java.time.LocalDate;
import com.annie.todo.enums.Priority;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponseDTO {

    private Long id;

    private String task;

    private String description;

    private LocalDate dueDate;

    private boolean done;

    private Priority priority;
    public TaskResponseDTO(Long id, String taskName, String description, LocalDate dueDate, Boolean done, Priority priority) {
        this.id = id;
        this.task = taskName;
        this.description = description;
        this.dueDate = dueDate;
        this.done = done;
        this.priority = priority;
    }
}
