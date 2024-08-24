package com.newagesoft.hinario.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidHinoException.class)
    public ResponseEntity<String> handleInvalidHinoException(InvalidHinoException exception){
        return ResponseEntity.badRequest().build();
    }
}
