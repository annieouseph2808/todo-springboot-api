package com.annie.todo.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class TaskSummaryDTO {
	private Long id;
    private String task;
    private boolean done;
}
