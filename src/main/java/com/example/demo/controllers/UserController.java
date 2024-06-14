package com.example.demo.controllers;

import com.example.demo.entity.User;
import com.example.demo.payload.ApiResponse;
import com.example.demo.services.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserServiceI userServiceI;

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
//          User user1= userServiceI.createUser(user);
//           return new ResponseEntity<>(user1, HttpStatus.CREATED);//201
//Or
        return ResponseEntity.ok(userServiceI.createUser(user));
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> allUsers = userServiceI.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable Long userId) throws Exception {
        User user = userServiceI.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long userId) {
        User updatedUser = userServiceI.updateUserById(user, userId);
        return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long userId) {
        userServiceI.deleteUserById(userId);
        return ResponseEntity.status(HttpStatus.OK)
                             .body(new ApiResponse("User is deleted successfully !!", true));
    }

    @DeleteMapping("/users/delete-all")
    public ResponseEntity<ApiResponse> deleteAllUsers(){
        userServiceI.deleteAllUsers();
        return ResponseEntity.ok().body(new ApiResponse("Users deleted successfully!!", true));
    }
}
