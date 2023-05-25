package com.pharmaplus.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pharmaplus.user.entity.Role;
import com.pharmaplus.user.entity.User;
import com.pharmaplus.user.exception.NotFoundException;
import com.pharmaplus.user.repository.RoleRepository;
import com.pharmaplus.user.service.RoleService;
import com.pharmaplus.user.utility.ApiResponse;

@RestController
@RequestMapping(value = "/role")
@CrossOrigin
public class RoleController {
	
	@Autowired
	RoleRepository roleRepository;
	
	// Get all Role
	@GetMapping("/all")
	public ApiResponse<List<Role>> getRoles() {
		List<Role> roles = roleRepository.findAll();
		return new ApiResponse<>(true, "Roles found successfully.", roles);
	}
	
	// Get Role By Id
	@GetMapping("/id/{id}")
	public ApiResponse<Role> getRoleById(@PathVariable String id) throws NotFoundException{
		Role role = roleRepository.findById(id).orElseThrow(() -> new NotFoundException("Role not found for this id :: " + id));
		return new ApiResponse<>(true, "Role found successfully.", role);
	}
	
	@GetMapping("/name/{name}")
	public ApiResponse<Role> getRoleByName(@PathVariable String name) throws NotFoundException{
		Role role = roleRepository.findByName(name).orElseThrow(() -> new NotFoundException("Role not found for this id :: " + name));
		return new ApiResponse<>(true, "Role found successfully.", role);
	}

}
