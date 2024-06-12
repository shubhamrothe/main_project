package com.example.demo.services;

import com.example.demo.entity.User;

import java.util.List;

public interface UserServiceI {

    //To create user
    User createUser(User user);

    //To update user by Id
    User updateUserById(User user, Long userId);

    // Get User
    User getUserById(Long userId);

    //Get all users
    List<User> getAllUsers();

    //Delete user by Id
    void deleteUserById(Long userId);
}
