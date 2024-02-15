package com.comport.cp.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(AppException.class)
    public ResponseEntity<?> handleException(AppException e) {
        Object body = e.getMessage() != null ? Map.of("message", e.getMessage()) : null;
        return ResponseEntity.status(e.getStatus()).body(body);
    }
}
