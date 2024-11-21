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
    UserService userService;
    @Override
    public void run(String... args) throws Exception {


            User user = new User("Arthur", "arthurvasc", "arthur008");
            userService.saveUser(user);
    }
}
