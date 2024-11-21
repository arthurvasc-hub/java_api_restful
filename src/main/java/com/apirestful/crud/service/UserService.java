package com.apirestful.crud.service;


import com.apirestful.crud.model.User;
import com.apirestful.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;


    @Autowired
    public UserService(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public User saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public User updateUser(User newUser, long id) {
        User user = repository.findById(id).orElseThrow(()-> new RuntimeException("User not found!"));

            if (newUser.getName() != null)
                user.setName(newUser.getName());

            if (newUser.getUsername() != null)
                user.setUsername(newUser.getUsername());

            if (newUser.getPassword() != null && !newUser.getPassword().isBlank())
                user.setPassword(encoder.encode(newUser.getPassword()));

        return repository.save(user);
    };
    public User getUserById(long id) {
        User user = repository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
        return user;
    };

    public List<User> getAllUsers() {
        return repository.findAll();
    };

    public void deleteUserById(long id) {
        if (repository.findById(id).isPresent() )
            repository.deleteById(id);
        else
            throw new RuntimeException("User not found!");
    };
}
