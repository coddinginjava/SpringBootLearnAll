package com.sai.SpringBootLearnAll.controller;

import com.sai.SpringBootLearnAll.DTO.UserRequest;
import com.sai.SpringBootLearnAll.advice.TimeTracker;
import com.sai.SpringBootLearnAll.entity.User;
import com.sai.SpringBootLearnAll.exceptions.UserNotFoundExceptions;
import com.sai.SpringBootLearnAll.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<User> findById(@PathVariable("id") Integer id) throws UserNotFoundExceptions {
        return ResponseEntity.ok(userService.findById(id));
    }
 }
