package com.comport.cp.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(AppException.class)
    public ResponseEntity<?> handleException(AppException e) {
        return ResponseEntity.status(e.getStatus()).body(e.getMessage());
    }
}
