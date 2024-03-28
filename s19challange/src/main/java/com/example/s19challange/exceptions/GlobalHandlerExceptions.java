package com.example.s19challange.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalHandlerExceptions {

    @ExceptionHandler
    public ResponseEntity<ErrorResponseExceptions> handleError(GlobalExceptions globalExceptions){
        ErrorResponseExceptions errorResponseExceptions = new ErrorResponseExceptions(globalExceptions.getStatus().value(),
                globalExceptions.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponseExceptions, globalExceptions.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponseExceptions> handleError(Exception exception){
        ErrorResponseExceptions errorResponseExceptions = new ErrorResponseExceptions(HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponseExceptions,HttpStatus.BAD_REQUEST);
    }
}
