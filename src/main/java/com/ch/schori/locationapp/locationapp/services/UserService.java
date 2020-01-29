package com.ch.schori.locationapp.locationapp.services;

import com.ch.schori.locationapp.locationapp.entities.LoginForm;
import com.ch.schori.locationapp.locationapp.entities.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    List<User> getAllUsers();
    LoginForm login(User user);
}
