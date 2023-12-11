package com.workshop.scrumboard.repository;

import com.workshop.scrumboard.model.Task;
import com.workshop.scrumboard.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Integer> {

    List<Task> findByName(String name);

    List<Task> findByStatus(String status);

    List<Task> findByAssignee(User assignee);


}
