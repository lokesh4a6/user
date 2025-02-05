package com.ecomerce.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
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
		
	/*
	 * @Autowired private UserService userService;
	 */
	
	@PostMapping("/add")
	public String addUser(@RequestBody User user) {
		//String userid = userService.addUser(user);
		return "hello";
	}
	
	@GetMapping("/getUser")
	public String getUser() {
		// String userid = userService.addUser(user);
		return "hello";
	}
}
