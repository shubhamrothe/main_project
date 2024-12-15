package com.example.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repositories.UserRepositoryI;
import com.example.demo.services.UserServiceI;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class UserServiceImpl implements UserServiceI {
//Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepositoryI userRepositoryI;

    @Override
    public User createUser(User user) {
        log.info("Initiating and completed the service layer to create a user");
        return userRepositoryI.save(user);

    }

    @Override
    public User updateUserById(User user, Long userId) {
        log.info("Initiating the service layer to update the user of userId {}:",userId);
        User user1 = userRepositoryI.findById(userId).get();

        user1.setUserName(user.getUserName());
        user1.setUserAge(user.getUserAge());
        user1.setAbout(user.getAbout());
        // User updatedUser =userRepositoryI.save(user1);
        log.info("Completed the service layer to update the user of userId {}:",userId);
        return userRepositoryI.save(user1);
    }

    @Override
    public User getUserById(Long userId) throws Exception {
        log.info("Initiating and completed the service layer to get a user of userId {}:",userId);
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
        log.info("Initiating the service layer to get all users");
        List<User> getAll = (List<User>) userRepositoryI.findAll();
        log.info("Completed the service layer to get all users");
        return getAll;
    }

    @Override
    public void deleteUserById(Long userId) {
        log.info("Initiating the service layer to delete the user of userId {}:",userId);
        User user = userRepositoryI.findById(userId)
                .orElseThrow(() -> new RuntimeException("Not found!!"));
        userRepositoryI.delete(user);
        log.info("Completed the service layer to delete the user of userId {}:",userId);
    }

    @Override
    public void deleteAllUsers() {
        log.info("Initiating and completed the service layer to delete all users");
        userRepositoryI.deleteAll();
    }
}
