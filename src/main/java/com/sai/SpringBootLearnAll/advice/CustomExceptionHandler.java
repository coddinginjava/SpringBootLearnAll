package com.sai.SpringBootLearnAll.advice;

import com.sai.SpringBootLearnAll.entity.User;
import com.sai.SpringBootLearnAll.exceptions.UserNotFoundExceptions;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String, String> handleInvalidArg(ConstraintViolationException e) {

        Map<String, String> errorMap = new HashMap<>();

        e.getConstraintViolations().forEach(cv -> errorMap.put(cv.getPropertyPath().toString(), cv.getMessage()));

        return errorMap;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundExceptions.class)
    public Map<String,String> handleUserNotFound(UserNotFoundExceptions une){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage",une.getMessage());
        return errorMap;
    }
}
