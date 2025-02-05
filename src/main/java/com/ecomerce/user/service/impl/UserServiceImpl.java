package com.ecomerce.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomerce.user.dto.User;
import com.ecomerce.user.entity.UserEntity;
import com.ecomerce.user.repository.UserRepository;
import com.ecomerce.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public String addUser(UserEntity user) {
		UserEntity savedUser = (UserEntity)userRepository.save(user);
		return "1";
	}

	@Override
	public String deleteUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
