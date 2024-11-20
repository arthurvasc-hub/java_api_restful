package com.apirestful.crud.controller;


import com.apirestful.crud.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UsersController {

    @GetMapping("/get")
    public List<User> getUsers(){
        return getUsers();
    }
}
