package com.ecomerce.user.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleUserNotFoundException(UserNotFoundException ex){
		Map<String, Object> resMap = new HashMap<String, Object>();
		
		resMap.put("status" , HttpStatus.BAD_REQUEST);
		resMap.put("error" , "User not found");
		resMap.put("message" , ex.getMessage());
		resMap.put("timestamp" , LocalDateTime.now());	
	
		return new ResponseEntity<>(resMap, HttpStatus.BAD_REQUEST);
	}
}
