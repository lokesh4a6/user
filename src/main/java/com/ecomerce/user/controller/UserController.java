package com.ecomerce.user.controller;

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
	
	@GetMapping("/getUser/{id}")
	public ResponseEntity<User> getUser(@PathVariable Long id) {
		User user = userService.getById(id);
	      return ResponseEntity.ok(user);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateUser(@RequestBody User user){
		String res = userService.updateUser(user);
		return new ResponseEntity<>(res , HttpStatus.OK );
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long userId){
		String res = userService.deleteUser(userId);
		return new ResponseEntity<>(res , HttpStatus.OK );
	}
}
