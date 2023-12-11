package com.workshop.scrumboard.repository;

import com.workshop.scrumboard.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findUserById(Integer id);

    List<User> findByUsername(String username);

}
