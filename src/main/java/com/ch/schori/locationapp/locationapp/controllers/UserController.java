package com.ch.schori.locationapp.locationapp.controllers;

import com.ch.schori.locationapp.locationapp.entities.Location;
import com.ch.schori.locationapp.locationapp.entities.User;
import com.ch.schori.locationapp.locationapp.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static String UPLOADED_FOLDER = "P:\\Java Projects\\locationapp\\src\\main\\java\\com\\ch\\schori\\locationapp\\locationapp\\images\\";

    @Autowired
    UserServiceImpl userService;

    @CrossOrigin
    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

//    @CrossOrigin
//    @GetMapping
//    public List<User> getUsersWithLocationCount() {
//        return userService.getAllUsersWithLocationCount();
//    }

    @CrossOrigin
    @PostMapping
    public User createUser(@RequestParam String username, @RequestParam String password, @RequestParam("file") MultipartFile file) {
        Date date = new Date();
        long timeMilli = date.getTime();
        String filename = timeMilli + "_" + file.getOriginalFilename();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setImagename(filename);

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + filename);
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userService.saveUser(user);
    }

    @CrossOrigin
    @PostMapping("/login")
    public LoginForm login(@RequestBody User user) {
        return userService.login(user);
    }
}
