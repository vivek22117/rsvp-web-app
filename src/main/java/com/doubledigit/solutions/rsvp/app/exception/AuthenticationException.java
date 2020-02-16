package com.doubledigit.solutions.rsvp.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class AuthenticationException extends Exception {

    private String message;

    public AuthenticationException(String message) {
        this.message = message;
    }

    public AuthenticationException() {
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void printStackTrace() {
        System.err.println(message);
    }
}
