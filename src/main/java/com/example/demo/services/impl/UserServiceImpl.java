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
        return userRepositoryI.save(user);
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
    public User getUserById(Long userId) throws Exception {
        //return userRepositoryI.findById(userId).get();

//OR  To avoid null pointer exception we uses here optional class
      /* Optional<User> user= userRepositoryI.findById(userId);
       if(user.isPresent()){
           return user.get();
       }else{
           throw new Exception("Resource not found on server!!"+ userId);
       }*/
        //OR
        return userRepositoryI.findById(userId).orElseThrow(() -> new RuntimeException("Resources are not found on server !!"));
    }

    @Override
    public List<User> getAllUsers() {
        List<User> getAll = (List<User>) userRepositoryI.findAll();
        return getAll;
    }

    @Override
    public void deleteUserById(Long userId) {
        User user = userRepositoryI.findById(userId)
                .orElseThrow(() -> new RuntimeException("Not found!!"));
        userRepositoryI.delete(user);
    }

    @Override
    public void deleteAllUsers() {
        userRepositoryI.deleteAll();
    }
}
