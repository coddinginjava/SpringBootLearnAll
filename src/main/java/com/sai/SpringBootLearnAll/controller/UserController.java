package com.sai.SpringBootLearnAll.controller;

import com.sai.SpringBootLearnAll.DTO.Person;
import com.sai.SpringBootLearnAll.DTO.UserRequest;
import com.sai.SpringBootLearnAll.advice.TimeTracker;
import com.sai.SpringBootLearnAll.entity.User;
import com.sai.SpringBootLearnAll.exceptions.UserNotFoundExceptions;
import com.sai.SpringBootLearnAll.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/saveUser")
    public ResponseEntity<User> saveUSer(@RequestBody @Valid UserRequest userRequest) {
        return ResponseEntity.ok(userService.saveUser(userRequest));
    }


    @GetMapping("/fetchAll")
    @TimeTracker
    public ResponseEntity<List<User>> getAllSavedUser(){
        return  ResponseEntity.ok(userService.findAllUsers());
    }

    @GetMapping("/find/{id}")
    @Cacheable(value = "product", key = "#id")
    @TimeTracker
    public User findById(@PathVariable("id") Integer id) throws UserNotFoundExceptions {
        return userService.findById(id);
    }


    @CircuitBreaker(name = "personService")
    @GetMapping("/person")
    @TimeTracker
    public Person getPerson(){
        return userService.getPersonFromMS();
    }
 }
