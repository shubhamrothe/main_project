package com.example.demo.controllers;

import com.example.demo.entity.User;
import com.example.demo.payload.ApiResponse;
import com.example.demo.services.UserServiceI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
//@Slf4j
public class UserController {

    @Autowired
    private UserServiceI userServiceI;

    Logger logger = (Logger) LoggerFactory.getLogger(UserController.class);

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
      //  log.info("Requesting to create a user");
        logger.info("Requesting to create a user");
//          User user1= userServiceI.createUser(user);
//           return new ResponseEntity<>(user1, HttpStatus.CREATED);//201
//Or
        logger.info("Completed the request to create a user");
        return ResponseEntity.ok(userServiceI.createUser(user));
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        logger.info("Requesting to get all users");
        List<User> allUsers = userServiceI.getAllUsers();
        logger.info("Completed the request to get all users");
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable Long userId) throws Exception {
        logger.info("Requesting to get single user with userId {}:",userId);
        User user = userServiceI.getUserById(userId);
        logger.info("completed the request to get single user with userId {}:",userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long userId) {
        logger.info("Requesting to update single user with userId {}:",userId);
        User updatedUser = userServiceI.updateUserById(user, userId);
        logger.info("completed the request to update single user with userId {}:",userId);
        return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long userId) {
        logger.info("Requesting to delete single user with userId {}:",userId);
        userServiceI.deleteUserById(userId);
        logger.info("completed the request to delete single user with userId {}:",userId);
        return ResponseEntity.status(HttpStatus.OK)
                             .body(new ApiResponse("User is deleted successfully !!", true));
    }

    @DeleteMapping("/users/delete-all")
    public ResponseEntity<ApiResponse> deleteAllUsers(){
        logger.info("Requesting to delete all users");
        userServiceI.deleteAllUsers();
        logger.info("completed the request to delete all users");
        return ResponseEntity.ok().body(new ApiResponse("Users deleted successfully!!", true));
    }
}
