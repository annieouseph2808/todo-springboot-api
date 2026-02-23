package com.annie.todo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.annie.todo.entity.Task;
public interface TodoRepository extends JpaRepository<Task,Long>{
	List<Task> findByDone(boolean done);

}
