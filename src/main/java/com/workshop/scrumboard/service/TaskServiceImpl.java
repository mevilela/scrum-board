package com.workshop.scrumboard.service;

import com.workshop.scrumboard.model.Task;
import com.workshop.scrumboard.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findByStatus(String status) {
        return taskRepository.findByStatus(status);
    }

    @Override
    public Task createNewTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Integer id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task findById(Integer id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()){
            return optionalTask.get();
        }
        throw new RuntimeException("task not found.");

    }

    @Override
    public void updateTask(Task task) {
        if (task.getStatus().equals("To Do")){
            task.setStatus("In Progress");
        } else {
            task.setStatus("Done");
        }

        taskRepository.save(task);
    }
}
