package com.ecomerce.user.service;

import com.ecomerce.user.dto.User;

public interface UserService {

	public Long addUser(User user);
	public User getById(Long id);
	public String deleteUser(Long id);
	public String updateUser(User user);
}
