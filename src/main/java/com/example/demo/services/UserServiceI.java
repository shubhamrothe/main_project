package com.example.demo.services;

import com.example.demo.entity.User;

import java.util.List;

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
