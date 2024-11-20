package com.apirestful.crud;

import com.apirestful.crud.model.User;
import com.apirestful.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class MyApp implements CommandLineRunner {
    @Autowired
    UserRepository repository;
    @Override
    public void run(String... args) throws Exception {
        User user = new User("Mamofi", "mamofi", "arthur008");
        repository.save(user);
    }
}
