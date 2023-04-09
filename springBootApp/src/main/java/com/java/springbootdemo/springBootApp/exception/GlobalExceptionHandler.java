package com.java.springbootdemo.springBootApp.exception;

import com.java.springbootdemo.springBootApp.model.response.StudentErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler // this method handles exception
    public ResponseEntity<StudentErrorResponse> handleException(CustomExceptionHandler exceptionHandler) {
        return new ResponseEntity<>(new StudentErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exceptionHandler.getMessage(),
                System.currentTimeMillis()),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler // this method handles bad request exception
    public ResponseEntity<StudentErrorResponse> handleBadRequestException(Exception exceptionHandler) {
        return new ResponseEntity<>(new StudentErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exceptionHandler.getMessage(),
                System.currentTimeMillis()),HttpStatus.BAD_REQUEST);
    }

}
