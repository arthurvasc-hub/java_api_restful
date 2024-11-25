package com.apirestful.crud.controller;


import com.apirestful.crud.model.User;
import com.apirestful.crud.repository.UserRepository;
import com.apirestful.crud.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
        return ResponseEntity.status(HttpStatus.OK).body(user);
    };

    @PostMapping()
    public ResponseEntity<Optional<User>> createUser(@Valid @RequestBody User user){
        Optional<User> newUser = Optional.ofNullable(userService.createUser(user));
        return ResponseEntity.status(HttpStatus.CREATED).header("Location", "/users/" + newUser.get())
                    .body(newUser);

    };

    @PutMapping("/{id}")
        public ResponseEntity<Optional<User>> updateUser(@PathVariable long id,@Valid @RequestBody User user){
        Optional<User> newUser = Optional.ofNullable(userService.updateUser(user,id));
            return ResponseEntity.status(HttpStatus.OK).body(newUser);
    };

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id){
        Optional<User> user = Optional.ofNullable(userService.getUserById(id));
        userService.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body("User deleted: " + user.get());
    };
}
