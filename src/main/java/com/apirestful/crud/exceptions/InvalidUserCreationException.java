package com.apirestful.crud.exceptions;

public class InvalidUserCreationException extends RuntimeException {

    public InvalidUserCreationException() {
        super("User creation failed");
    }
    public InvalidUserCreationException(String message) {
        super(message);
    }
}
