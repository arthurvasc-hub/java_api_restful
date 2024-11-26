package com.apirestful.crud;

import com.apirestful.crud.model.User;
import com.apirestful.crud.repository.UserRepository;
import com.apirestful.crud.service.UserService;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class MyApp implements CommandLineRunner {

    @Autowired
    UserService userService;
    @Override
    public void run(String... args) throws Exception {

    }
}
