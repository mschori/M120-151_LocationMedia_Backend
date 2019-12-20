package com.ch.schori.locationapp.locationapp.controllers;

import com.ch.schori.locationapp.locationapp.entities.User;
import com.ch.schori.locationapp.locationapp.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @CrossOrigin
    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @CrossOrigin
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @CrossOrigin
    @PostMapping("/login")
    public LoginForm login(@RequestBody User user) {
        return userService.login(user);
    }
}
