package com.sai.SpringBootLearnAll.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sai.SpringBootLearnAll.DTO.UserRequest;
import com.sai.SpringBootLearnAll.entity.User;
import com.sai.SpringBootLearnAll.exceptions.UserNotFoundExceptions;
import com.sai.SpringBootLearnAll.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public ObjectMapper objectMapper;

    public User saveUser(UserRequest userRequest) {
        User user = objectMapper.convertValue(userRequest, User.class);
        return userRepository.save(user);
    }

    public List<User> findAllUsers(){
        return  userRepository.findAll();
    }

    public User findById(Integer id) throws UserNotFoundExceptions {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return  user.get();
        }else {
            throw new UserNotFoundExceptions("User id not found in the DB with id: "  + id);
        }
    }
}
