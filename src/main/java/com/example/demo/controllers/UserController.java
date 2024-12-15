package com.example.demo.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.payload.CustomApiResponse;
import com.example.demo.services.UserServiceI;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/users")
//@Slf4j
@Tag(name = "User Controller", description = "API for managing users")
public class UserController {

	@Autowired
	private UserServiceI userServiceI;

	Logger logger = (Logger) LoggerFactory.getLogger(UserController.class);

	@Operation(summary = "Create a new user", description = "Adds a new user to the database and returns the created user")
	@ApiResponses({
			@ApiResponse(responseCode = "201", description = "User created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))),
			@ApiResponse(responseCode = "400", description = "Invalid input", content = @Content) })
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		// log.info("Requesting to create a user");
		logger.info("Requesting to create a user");
//          User user1= userServiceI.createUser(user);
//           return new ResponseEntity<>(user1, HttpStatus.CREATED);//201
//Or
		logger.info("Completed the request to create a user");
		return ResponseEntity.ok(userServiceI.createUser(user));
	}

	
	 @Operation(
		        summary = "Get all users",
		        description = "Fetches all users from the database"
		    )
		    @ApiResponses({
		        @ApiResponse(responseCode = "200", description = "Users fetched successfully", 
		                     content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))),
		        @ApiResponse(responseCode = "404", description = "No users found", content = @Content)
		    })
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		logger.info("Requesting to get all users");
		List<User> allUsers = userServiceI.getAllUsers();
		logger.info("Completed the request to get all users");
		return new ResponseEntity<>(allUsers, HttpStatus.OK);
	}

	 
	 @Operation(
		        summary = "Get a user by ID",
		        description = "Fetches a user by their unique ID"
		    )
		    @ApiResponses({
		        @ApiResponse(responseCode = "200", description = "User fetched successfully", 
		                     content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))),
		        @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
		    })
	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable Long userId) throws Exception {
		logger.info("Requesting to get single user with userId {}:", userId);
		User user = userServiceI.getUserById(userId);
		logger.info("completed the request to get single user with userId {}:", userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	 
	 @Operation(
		        summary = "Update a user",
		        description = "Updates an existing user by their unique ID"
		    )
		    @ApiResponses({
		        @ApiResponse(responseCode = "200", description = "User updated successfully", 
		                     content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))),
		        @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
		    })
	@PutMapping("/{userId}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long userId) {
		logger.info("Requesting to update single user with userId {}:", userId);
		User updatedUser = userServiceI.updateUserById(user, userId);
		logger.info("completed the request to update single user with userId {}:", userId);
		return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
	}
	 
	 
	 @Operation(
		        summary = "Delete a user by ID",
		        description = "Deletes a user by their unique ID"
		    )
		    @ApiResponses({
		        @ApiResponse(responseCode = "200", description = "User deleted successfully", 
		                     content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponse.class))),
		        @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
		    })
	@DeleteMapping("/{userId}")
	public ResponseEntity<CustomApiResponse> deleteUser(@PathVariable Long userId) {
		logger.info("Requesting to delete single user with userId {}:", userId);
		userServiceI.deleteUserById(userId);
		logger.info("completed the request to delete single user with userId {}:", userId);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new CustomApiResponse("User is deleted successfully !!", true));
	}

	 
	 @Operation(
		        summary = "Delete all users",
		        description = "Deletes all users from the database"
		    )
		    @ApiResponses({
		        @ApiResponse(responseCode = "200", description = "All users deleted successfully", 
		                     content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponse.class)))
		    })
	@DeleteMapping
	public ResponseEntity<CustomApiResponse> deleteAllUsers() {
		logger.info("Requesting to delete all users");
		userServiceI.deleteAllUsers();
		logger.info("completed the request to delete all users");
		return ResponseEntity.ok().body(new CustomApiResponse("Users deleted successfully!!", true));
	}
}
