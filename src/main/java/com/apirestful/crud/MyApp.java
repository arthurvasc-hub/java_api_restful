package com.apirestful.crud;

import com.apirestful.crud.model.User;
import com.apirestful.crud.repository.UserRepository;
import com.apirestful.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class MyApp implements CommandLineRunner {

    @Autowired
    UserRepository repository;
    UserService service;
    @Override
    public void run(String... args) throws Exception {

    }
}
