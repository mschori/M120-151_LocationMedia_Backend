package com.ch.schori.locationapp.locationapp.services;

import com.ch.schori.locationapp.locationapp.entities.LoginForm;
import com.ch.schori.locationapp.locationapp.entities.User;
import com.ch.schori.locationapp.locationapp.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public LoginForm login(User user) {
        try {
            User fetchedUser = userRepository.getUserByUsername(user.getUsername());
            if (fetchedUser.getPassword().equals(user.getPassword())) {
                return new LoginForm(fetchedUser.getId(), true);
            } else {
                return new LoginForm(0L, false);
            }
        } catch (Exception e) {
            return new LoginForm(0L, false);
        }
    }
}
