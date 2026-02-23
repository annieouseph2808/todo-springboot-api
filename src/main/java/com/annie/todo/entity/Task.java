package com.annie.todo.entity;

import java.time.LocalDate;

import com.annie.todo.enums.Priority;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="tasks")
@Getter
@Setter
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String taskName;
	private String description;
	private LocalDate dueDate;
	private boolean done;
	@Enumerated(EnumType.STRING)
	private Priority priority;


//Getter for id
public Long getId() {
 return id;
}

//Getter for taskName
public String getTaskName() {
 return taskName;
}

//Getter for desc
public String getDescription() {
 return description;
}

//Getter for dueDate
public LocalDate getDueDate() {
 return dueDate;
}

//Getter for done (Boolean)
public Boolean getDone() {
 return done;
}

//Getter for priority
public Priority getPriority() {
 return priority;
}
public void setId(Long id) {
    this.id = id;
}

public void setTaskName(String taskName) {
    this.taskName = taskName;
}

public void setDescription(String description) {
    this.description = description;
}

public void setDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
}

public void setDone(Boolean done) {
    this.done = done;
}

public void setPriority(Priority priority) {
    this.priority = priority;
}
}
