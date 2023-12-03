package com.java.springbootdemo.springBootApp.exception;

import com.java.springbootdemo.springBootApp.model.response.StudentErrorResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler // this method handles exception
    public ResponseEntity<StudentErrorResponse> handleException(CustomExceptionHandler exceptionHandler) {
        return new ResponseEntity<>(new StudentErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exceptionHandler.getMessage(),
                System.currentTimeMillis()),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    @ResponseStatus(BAD_REQUEST) // this method handles bad request exception
    public ResponseEntity<Object> handleBadRequestException(MethodArgumentNotValidException exceptionHandler) {
        Map<String, String> errorMap = new HashMap<>();
        exceptionHandler.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(),error.getDefaultMessage());
        });
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }

}
