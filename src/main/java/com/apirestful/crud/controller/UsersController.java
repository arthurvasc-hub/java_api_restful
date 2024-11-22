package com.apirestful.crud.controller;


import com.apirestful.crud.model.User;
import com.apirestful.crud.repository.UserRepository;
import com.apirestful.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UserRepository repository;
    @Autowired
    private UserService userService;

    @GetMapping()
    public List<User> getUsers(){
       return userService.getAllUsers();
    };

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id){
        return userService.getUserById(id);
    };

    @PostMapping()
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    };

    @PutMapping("/{id}")
    public User updateUser(@PathVariable long id, @RequestBody User user){
        return userService.updateUser(user, id);

    };

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id){
        userService.deleteUserById(id);
    };
}
