package com.example.demo.services.impl;

import com.example.demo.entity.User;
import com.example.demo.repositories.UserRepositoryI;
import com.example.demo.services.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserServiceI {


    @Autowired
    private UserRepositoryI userRepositoryI;

    @Override
    public User createUser(User user) {

        return null;
    }

    @Override
    public User updateUserById(User user, Long userId) {

        User user1 = userRepositoryI.findById(userId).get();

        user1.setUserName(user.getUserName());
        user1.setUserAge(user.getUserAge());
        user1.setAbout(user.getAbout());
       // User updatedUser =userRepositoryI.save(user1);
        return userRepositoryI.save(user1);
    }

    @Override
    public User getUserById(Long userId) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }

    @Override
    public void deleteUserById(Long userId) {

    }
}
