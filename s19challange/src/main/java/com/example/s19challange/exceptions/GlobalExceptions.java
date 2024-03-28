package com.example.s19challange.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class GlobalExceptions extends RuntimeException{
    private HttpStatus status;

    public GlobalExceptions(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
