package com.HouseKEpping.service;

import java.util.Set;

import com.HouseKEpping.entity.User;
import com.HouseKEpping.entity.UserRole;


public interface UserService {
	
	public User createUser(User user, Set<UserRole> userRoles);
	
	public User getUser(String username);

	public void deleteUSer(Long userId);

}