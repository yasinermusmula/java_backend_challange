package com.example.s19challange.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponseExceptions {
    private int status;
    private String message;
    private LocalDateTime localDateTime;
}
