package com.workshop.scrumboard.controller;

import com.workshop.scrumboard.model.Task;
import com.workshop.scrumboard.service.TaskService;
import com.workshop.scrumboard.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class TaskController {

    /*private static List<Task> tasks = new ArrayList<>();*/
    private final TaskService taskService;
    private final UserService userService;


    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping("/tasks/list")
    public String list(Model model){

        List<Task> toDo = taskService.findByStatus("To Do");
        List<Task> inProgress = taskService.findByStatus("In Progress");
        List<Task> done = taskService.findByStatus("Done");

        model.addAttribute("toDo", toDo);
        model.addAttribute("inProgress", inProgress);
        model.addAttribute("done", done);

        return "tasks/list";
    }

    @GetMapping("/tasks/create")
    public String createForm(Model model){
        model.addAttribute("task", new Task());
        model.addAttribute("users", userService.findAllUsers());

        return "tasks/create";
    }

    @PostMapping("/tasks/create")
    public String submitNewTask(@ModelAttribute Task task, Model model){

        // could be removed
        /*task.setId(new Random().nextInt());
        task.setStatus("To Do");*/

        taskService.createNewTask(task);

        // replace to use service -> repository to save data
        /*tasks.add(task);*/

        return "redirect:/tasks/list";
    }

    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable Integer id){

        // remove from service -> repository by id
        /*tasks.removeIf(task -> task.getId().equals(id));*/

        taskService.deleteTask(id);

        return "redirect:/tasks/list";
    }

    @PutMapping("/tasks/{id}")
    public String updateTask(@PathVariable Integer id){

        // load by id
        // set status
        // service -> repository -> save

        /*tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .ifPresent(task -> {
                    if (task.getStatus().equals("To Do")){
                        task.setStatus("In Progress");
                    } else {
                        task.setStatus("Done");
                    }
                });*/

       Task task = taskService.findById(id);

       taskService.updateTask(task);

        return "redirect:/tasks/list";
    }

}