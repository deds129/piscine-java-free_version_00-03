package com.company.day01;

public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
        super("User mot found");
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
