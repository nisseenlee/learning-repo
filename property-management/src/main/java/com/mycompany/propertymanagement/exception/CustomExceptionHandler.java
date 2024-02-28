package com.mycompany.propertymanagement.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorModel>> handleFieldValidation(MethodArgumentNotValidException e) {
        return new ResponseEntity<>(
                e.getFieldErrors().stream().map(err -> {
                    logger.error("Inside field validation: {} - {}", err.getField(), err.getDefaultMessage());
                    logger.error("Inside field validation: {} - {}", err.getField(), err.getDefaultMessage());
                    return new ErrorModel(err.getField(), err.getDefaultMessage());
                }).toList(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException e) {
        System.out.println("BusinessException is thrown");
        e.getErrors().forEach(err -> {
            logger.error("BusinessException is thrown: {} - {}", err.getCode(), err.getMessage());
            logger.error("BusinessException is thrownn: {} - {}", err.getCode(), err.getMessage());
        });
        return new ResponseEntity<>(e.getErrors(), HttpStatus.BAD_REQUEST);
    }
}
