package com.workshop.scrumboard.service;

import com.workshop.scrumboard.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

   List<User> findUserById(Integer id);

    List<User> findAllUsers();

    void deleteUser(Integer id);

    User createNewUser(User user);
}
