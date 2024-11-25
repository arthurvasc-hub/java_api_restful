package com.apirestful.crud.service;


import com.apirestful.crud.exceptions.InvalidUserCreationException;
import com.apirestful.crud.exceptions.UserNotFoundException;
import com.apirestful.crud.model.User;
import com.apirestful.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    };

    public User saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return repository.save(user);
    };
    // Criar usuário (POST)
    public User createUser(User user) throws InvalidUserCreationException {

            user.setName(user.getName());
            user.setUsername(user.getUsername());
            user.setPassword(encoder.encode(user.getPassword()));

        return saveUser(user);
    };
    // Atualizar usuário (PUT)
    public User updateUser(User newUser, long id) throws InvalidUserCreationException {

            User user = repository.findById(id).orElseThrow(UserNotFoundException::new);
            user.setName(newUser.getName());
            user.setUsername(newUser.getUsername());
            user.setPassword(encoder.encode(newUser.getPassword()));

        return saveUser(user);
    };

    // Encontrar usuário através do Id (GET)
    public User getUserById(long id) {
        return repository.findById(id).orElseThrow(UserNotFoundException::new);
    };

    // Ecnontrar todos os usuários (GET)
    public List<User> getAllUsers() {
        return repository.findAll();
    };

    // Deletar usuário através do Id (DELETE).
    public void deleteUserById(long id) {
        User user = repository.findById(id).orElseThrow(UserNotFoundException::new);
        repository.delete(user);
    };

}
