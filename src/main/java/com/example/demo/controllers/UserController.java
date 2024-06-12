package com.example.demo.controllers;

import com.example.demo.entity.User;
import com.example.demo.services.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserServiceI userServiceI;

    public ResponseEntity<User> createUser(){
        return null;
    }
}
