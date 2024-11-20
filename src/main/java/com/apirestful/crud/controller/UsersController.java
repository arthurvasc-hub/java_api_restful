package com.apirestful.crud.controller;


import com.apirestful.crud.model.User;
import com.apirestful.crud.repository.UserRepository;
import com.apirestful.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {
    UserRepository repository;
    @Autowired
    UserService userService;
    @GetMapping("/users")
    public List<User> getUsers(){
       return userService.getAllUsers();
    }
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }
}
