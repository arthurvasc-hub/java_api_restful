package com.apirestful.crud.service;


import com.apirestful.crud.model.User;
import com.apirestful.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

    public User updateUser(User user, long id) {
        User foundUser = repository.findById(id).orElseThrow(()-> new RuntimeException("User not found!"));

        //Atualizar os dados
        if(user.getPassword() != null) {
            foundUser.setPassword(encoder.encode(user.getPassword()));
        }
        foundUser.setName(user.getName());
        foundUser.setUsername(user.getUsername());
        foundUser.setPassword(user.getPassword());

        //Salvar as mudanças
        return repository.save(foundUser);
    }
}
