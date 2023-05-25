package com.pharmaplus.user.service;

import com.pharmaplus.user.entity.Role;
import com.pharmaplus.user.entity.User;
import com.pharmaplus.user.exception.NotFoundException;

public interface UserService {
	User saveUser(User user);
	//User findByUsername(String username);
	Role findByName(Role role);
	User addRoleToUser(String username, String name) throws NotFoundException;
}
