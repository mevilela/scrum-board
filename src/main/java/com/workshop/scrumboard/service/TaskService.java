package com.workshop.scrumboard.service;

import com.workshop.scrumboard.model.Task;

import java.util.List;

public interface TaskService  {

    List<Task> findByStatus(String status);

    Task createNewTask(Task task);

    void deleteTask(Integer id);

    Task findById(Integer id);

    void updateTask(Task task);
}
