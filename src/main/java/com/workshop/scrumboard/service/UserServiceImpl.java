package com.workshop.scrumboard.service;

import com.workshop.scrumboard.model.User;
import com.workshop.scrumboard.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findUserById(Integer id) {
        return userRepository.findUserById(id);
    }

    @Override
    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User createNewUser(User user) {
        return userRepository.save(user);
    }
}
