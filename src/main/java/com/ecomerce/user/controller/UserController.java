package com.ecomerce.user.controller;

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

import com.ecomerce.user.dto.User;
import com.ecomerce.user.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api")
@Tag(name = "User controller", description = "Crud operations for the users")
public class UserController {
	
	private static final Logger logger =  LoggerFactory.getLogger(UserController.class);
		
	  @Autowired
	  private UserService userService;
	 
	
	@PostMapping(value = "/add" , consumes = "application/json")
	@Operation(summary = "add user operation", description = "For adding the users")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		Long userid = userService.addUser(user);
		logger.info("user created with id:" + userid);
		ResponseEntity<String> res = new ResponseEntity<>("Created user: " + userid , HttpStatus.OK );
		return res;
	}
	
	@GetMapping(value = "/getUser/{id}", produces = "application/json")
	@Operation(summary = "get user by id operation", description = "For fetching the user by id")
	public ResponseEntity<User> getUser(@PathVariable Long id) {
		User user = userService.getById(id);
	      return ResponseEntity.ok(user);
	}
	
	@PutMapping(value = "/update" ,consumes = "application/json")
	@Operation(summary = "update user operation", description = "For updating the user")
	public ResponseEntity<String> updateUser(@RequestBody User user){
		String res = userService.updateUser(user);
		return new ResponseEntity<>(res , HttpStatus.OK );
	}
	
	@DeleteMapping("/delete/{id}")
	@Operation(summary = "delete user operation", description = "For deleting the user")
	public ResponseEntity<String> deleteUser(@PathVariable Long id){
		String res = userService.deleteUser(id);
		return new ResponseEntity<>(res , HttpStatus.OK );
	}
}
