package com.workshop.scrumboard.controller;

import com.workshop.scrumboard.model.User;
import com.workshop.scrumboard.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/list")
    public String list(Model model){

        List<User> users = userService.findAllUsers();

        model.addAttribute("users", users);

        return "users/list";
    }



    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Integer id){

        userService.deleteUser(id);

        return "redirect:/users/list";

    }

    @GetMapping("users/create")
    public String getUserCreateForm(Model model){

        model.addAttribute("user", new User());

        return "users/create";
    }

    @PostMapping("users/create")
    public String createNewUser(@ModelAttribute User user, Model model){

        userService.createNewUser(user);

        return "redirect:/users/list";
    }


}
