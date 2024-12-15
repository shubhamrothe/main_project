package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.User;

public interface UserServiceI {

    //To Create User
    User createUser(User user);

    //To Update User By Id
    User updateUserById(User user, Long userId);

    // Get User By Id
    User getUserById(Long userId) throws Exception;

    //Get All Users
    List<User> getAllUsers();

    //Delete User By Id
    void deleteUserById(Long userId);

    //Delete All Users
    void deleteAllUsers();
}
