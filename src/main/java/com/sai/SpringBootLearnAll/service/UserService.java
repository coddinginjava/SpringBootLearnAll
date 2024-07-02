package com.sai.SpringBootLearnAll.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sai.SpringBootLearnAll.DTO.Person;
import com.sai.SpringBootLearnAll.DTO.UserRequest;
import com.sai.SpringBootLearnAll.entity.User;
import com.sai.SpringBootLearnAll.exceptions.UserNotFoundExceptions;
import com.sai.SpringBootLearnAll.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class UserService  {

    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;
    private final RestClient restClient;

    public User saveUser(UserRequest userRequest) {
        User user = objectMapper.convertValue(userRequest, User.class);
        return userRepository.save(user);
    }


    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findById(Integer id) throws UserNotFoundExceptions {

        Optional<User> user = userRepository.findById(id);


        log.info("Got user from the db");
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UserNotFoundExceptions("User id not found in the DB with id: " + id);
        }
    }


    @PostConstruct
    public void initDb() {
        userRepository.saveAll(List.of(User.build(1, "sai", 24, "7402100511", "M", "Indian", "sai@sai.com"),
                User.build(2, "Prakash", 25, "7904852594", "M", "Indn", "saasi@sfvfai.com")));
    }

    public Person getPersonFromMS() {

        Person person = restClient.get()
                .uri("/person")
                .retrieve().body(Person.class);

        return person;
    }
}
