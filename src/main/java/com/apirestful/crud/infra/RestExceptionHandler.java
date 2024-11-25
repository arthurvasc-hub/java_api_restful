package com.apirestful.crud.infra;


import com.apirestful.crud.exceptions.InvalidUserCreationException;
import com.apirestful.crud.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<String> userNotFoundHandler(UserNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

    @ExceptionHandler(InvalidUserCreationException.class)
    private ResponseEntity<String> userCreationHandler(InvalidUserCreationException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User creation failed");
    }


    // @Valid exception.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing required fields: name, username, or password");
    }
}
