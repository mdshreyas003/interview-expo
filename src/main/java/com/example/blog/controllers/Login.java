package com.example.blog.controllers;

import com.example.blog.entities.User;
import com.example.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/login")
public class Login {

    @Autowired
    private UserService userService;

    @PostMapping
    public User logUser(@RequestBody User user) {
        User u = userService.getUserByEmail(user.getEmail());
        if(user.getPassword().equals(u.getPassword())){
            u.setPassword("");
            return u;
        }
        return null;
    }

}