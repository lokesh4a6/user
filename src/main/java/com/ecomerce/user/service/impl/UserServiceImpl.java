package com.ecomerce.user.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomerce.user.dto.User;
import com.ecomerce.user.entity.UserEntity;
import com.ecomerce.user.repository.UserRepository;
import com.ecomerce.user.service.UserService;
import com.ecomerce.user.util.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;	
	
	@Override
	public Long addUser(User user) {
		UserEntity savedUser = userRepository.save(UserMapper.toEntity(user));
		logger.info("user created sucessfully: " + savedUser.getId());
		return savedUser.getId();
	}

	@Override
	public String deleteUser(Long id) {
		userRepository.deleteById(id);
		logger.info("user with id {} deleted sucessfully: " , id);
		return "User deleted sucessfully";
	}

	@Override
	public String updateUser(User user) {
		userRepository.save(UserMapper.toEntity(user));
		logger.info("user with id {} updated sucessfully: " , user.getId());
		return "Updated successfully";
	}

	@Override
	public User getById(Long id) {
		UserEntity savedUser = userRepository.getReferenceById(id);
		return UserMapper.toDTO(savedUser);
	}
}
