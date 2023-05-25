package com.pharmaplus.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pharmaplus.user.entity.ERole;
import com.pharmaplus.user.entity.Role;
import com.pharmaplus.user.entity.User;
import com.pharmaplus.user.exception.NotFoundException;
import com.pharmaplus.user.repository.RoleRepository;
import com.pharmaplus.user.repository.UserRepository;
import com.pharmaplus.user.service.UserService;

@Transactional
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	/*@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username).orElseThrow(() -> new NotFoundException("User not found for this username :: " + .getUsername()));
	}*/

	@Override
	public Role findByName(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public User addRoleToUser(String username, String name) throws NotFoundException{
		User user = userRepository.findByUsername(username).orElseThrow(() -> new NotFoundException("User not found for this username :: " + username));
		Role role = roleRepository.findByName(name).orElseThrow(() -> new NotFoundException("Role not found for this name :: " + name));
		List<Role> roles = new ArrayList<Role>();
		roles.add(role);
		System.out.println("role ===> " + role);
		user.setRoles(roles);
		System.out.println("user ===> " + user);
		userRepository.save(user);
		return user;
	}

}
