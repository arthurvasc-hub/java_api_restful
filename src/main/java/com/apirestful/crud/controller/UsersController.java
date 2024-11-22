package com.apirestful.crud.controller;


import com.apirestful.crud.model.User;
import com.apirestful.crud.repository.UserRepository;
import com.apirestful.crud.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Optional<User>> getUserById(@Valid @PathVariable long id){
        Optional<User> user = Optional.ofNullable(userService.getUserById(id));
        if(user.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(user);
        };
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(null);
    };

    @PostMapping()
    public ResponseEntity<Optional<User>> createUser(@Valid @RequestBody User user){
        Optional<User> newUser = Optional.ofNullable(userService.createUser(user));

        if(newUser.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).header("Location", "/users/" + newUser.get())
                    .body(newUser);
        };

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    };

    @PutMapping("/{id}")
    public ResponseEntity<Optional<User>> updateUser(@PathVariable long id,@Valid @RequestBody User user){
        Optional<User> newUser = Optional.ofNullable(userService.updateUser(user,id));

        if(newUser.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(newUser);
        };

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    };

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id){
        User user = userService.getUserById(id);

        if(user != null){
            userService.deleteUserById(id);
            ResponseEntity.status(HttpStatus.OK);
        } else
            ResponseEntity.status(HttpStatus.NOT_FOUND);
    };
}
