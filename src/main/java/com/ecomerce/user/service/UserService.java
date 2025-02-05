package com.ecomerce.user.service;

import com.ecomerce.user.dto.User;
import com.ecomerce.user.entity.UserEntity;

public interface UserService {

	String addUser(UserEntity user);
	String deleteUser(String id);
	String updateUser(String id);
}
