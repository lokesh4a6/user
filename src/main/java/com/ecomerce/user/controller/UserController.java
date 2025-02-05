package com.ecomerce.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomerce.user.dto.User;
import com.ecomerce.user.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
		
	  @Autowired
	  private UserService userService;
	 
	
	@PostMapping("/add")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		Long userid = userService.addUser(user);
		ResponseEntity<String> res = new ResponseEntity<>("Created user: " + userid , HttpStatus.OK );
		return res;
	}
	
	@GetMapping("/getUser")
	public String getUser() {
		// String userid = userService.addUser(user);
		return "hello";
	}
}
