package com.example.springbootRestApi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class CentralizedExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException e, WebRequest request){
        ErrorDetails details = new ErrorDetails(new Date(),e.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception e, WebRequest request){
        ErrorDetails details = new ErrorDetails(new Date(),e.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }


}
