package com.newagesoft.hinario.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidHinoException extends RuntimeException{
    public InvalidHinoException(String message) {
        super(message);
    }
}
