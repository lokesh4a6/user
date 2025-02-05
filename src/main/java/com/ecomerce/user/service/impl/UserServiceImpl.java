package com.ecomerce.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomerce.user.dto.User;
import com.ecomerce.user.entity.UserEntity;
import com.ecomerce.user.repository.UserRepository;
import com.ecomerce.user.service.UserService;
import com.ecomerce.user.util.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public Long addUser(User user) {
		userMapper.toEntity(user);
		UserEntity savedUser = (UserEntity)userRepository.save(userMapper.toEntity(user));
		return savedUser.getId();
	}

	@Override
	public String deleteUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateUser(User user) {
		UserEntity savedUser = userRepository.save(userMapper.toEntity(user));
		return "Updated successfully";
	}

	@Override
	public User getById(Long id) {
		UserEntity savedUser = userRepository.getReferenceById(id);
		return userMapper.toDTO(savedUser);
	}

	
}
