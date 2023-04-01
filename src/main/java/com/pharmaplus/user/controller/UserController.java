package com.pharmaplus.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pharmaplus.user.entity.User;
import com.pharmaplus.user.exception.NotFoundException;
import com.pharmaplus.user.repository.UserRepository;
import com.pharmaplus.user.utility.ApiResponse;

@RestController
@RequestMapping(value = "/pharmaplus/user")
public class UserController {

	@Autowired
	UserRepository userRepository;

	// Get all User
	@GetMapping("/all")
	public ApiResponse<List<User>> getUsers() {
		List<User> users = userRepository.findAll();
		return new ApiResponse<>(true, "Users found successfully.", users);
	}
	
	// Add User
	@PostMapping("/add")
	public ApiResponse<User> addUser(@RequestBody User user) {
		User savedUser = userRepository.save(user);
        return new ApiResponse<>(true, "User save Successfully.", savedUser);
	}
	
	// Get User By Id
	@GetMapping("/id/{id}")
	public ApiResponse<User> getUserById(@PathVariable String id) throws NotFoundException{
		User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found for this id :: " + id));
		return new ApiResponse<>(true, "User found successfully.", user);
	}
	
	// Update User By Id
	@PutMapping("/{id}")
	public ApiResponse<User> updateUser(@PathVariable("id") String id, @RequestBody User user) throws NotFoundException{
	    User updatedUser = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found for this id :: " + id));
	    updatedUser.setCivi(user.getCivi());
	    updatedUser.setEnable(user.getEnable());
	    updatedUser.setFonction(user.getFonction());
	    updatedUser.setIdentifiant(user.getIdentifiant());
	    updatedUser.setIdGroup(user.getIdGroup());
	    updatedUser.setNom(user.getNom());
	    updatedUser.setPrenom(user.getPrenom());
	    updatedUser.setPassword(user.getPassword());
	    return new ApiResponse<>(true, "User updated successfully.", updatedUser);
	}
	
	// Delete User By Id
	@DeleteMapping("/{id}")
	public ApiResponse<Void> deleteUser(@PathVariable("id") String id) {
	    userRepository.deleteById(id);
	    return new ApiResponse<>(true, "User deleted successfully.", null);
	}


}
