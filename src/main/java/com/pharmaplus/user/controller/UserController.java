package com.pharmaplus.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.pharmaplus.user.request.LoginRequest;
import com.pharmaplus.user.security.JwtResponse;
import com.pharmaplus.user.security.JwtUtils;
import com.pharmaplus.user.security.MyUserDetailsService;
import com.pharmaplus.user.service.UserService;
import com.pharmaplus.user.utility.ApiResponse;
import org.springframework.security.authentication.AuthenticationManager;


@RestController
@RequestMapping(value = "/user")
@CrossOrigin
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	//@Autowired
	//JwtProvider jwtProvider;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	private static final Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);
	
	@PostMapping("/login")
	public ApiResponse<?> authenticateUser(@RequestBody LoginRequest loginRequest) throws NotFoundException{
		// Authentifier l'utilisateur
	    Authentication authentication = authenticationManager.authenticate(
	            new UsernamePasswordAuthenticationToken(
	                    loginRequest.getUsername(),
	                    loginRequest.getPassword()
	            )
	    );
	    User user = userRepository.findByUsername(loginRequest.getUsername()).orElseThrow(() -> new NotFoundException("User not found for this username :: " + loginRequest.getUsername()));
	    // Créer le token JWT
	    SecurityContextHolder.getContext().setAuthentication(authentication);
	    String jwt = jwtUtils.generateJwtToken(authentication);
	    // Renvoyer le token JWT
	    return new ApiResponse<>(true, "User Authenticated successfully.", new JwtResponse(jwt, user));
	    //return ResponseEntity.ok(new JwtResponse(jwt));
	}

	// Get all User
	@GetMapping("/all")
	public ApiResponse<List<User>> getUsers() {
		List<User> users = userRepository.findAll();
		return new ApiResponse<>(true, "Users found successfully.", users);
	}
	
	// Add User
	@PostMapping("/add")
	public ApiResponse<User> addUser(@RequestBody User user) throws NotFoundException {
		userService.saveUser(user);
		User usr = userService.addRoleToUser(user.getUsername(), "USER");
        return new ApiResponse<>(true, "User save Successfully.", usr);
	}
	
	// Get User By Id
	@GetMapping("/id/{id}")
	public ApiResponse<User> getUserById(@PathVariable String id) throws NotFoundException{
		User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found for this id :: " + id));
		return new ApiResponse<>(true, "User found successfully.", user);
	}
	
	// Get User By Username
	@GetMapping("/username/{username}")
	public ApiResponse<User> getUserByUsername(@PathVariable String username) throws NotFoundException{
		User user = userRepository.findByUsername(username).orElseThrow(() -> new NotFoundException("User not found for this id :: " + username));
		return new ApiResponse<>(true, "User found successfully.", user);
	}
	
	// Update User By Id
	@PutMapping("/{id}")
	public ApiResponse<User> updateUser(@PathVariable("id") String id, @RequestBody User user) throws NotFoundException{
	    User updatedUser = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found for this id :: " + id));
	    updatedUser.setCivi(user.getCivi());
	    updatedUser.setEnable(user.getEnable());
	    updatedUser.setFonction(user.getFonction());
	    updatedUser.setUsername(user.getUsername());
	    updatedUser.setIdGroup(user.getIdGroup());
	    updatedUser.setFirstName(user.getFirstName());
	    updatedUser.setLastName(user.getLastName());
	    updatedUser.setPassword(user.getPassword());
	    userRepository.save(updatedUser);
	    return new ApiResponse<>(true, "User updated successfully.", updatedUser);
	}
	
	// Delete User By Id
	@DeleteMapping("/{id}")
	public ApiResponse<Void> deleteUser(@PathVariable("id") String id) {
	    userRepository.deleteById(id);
	    return new ApiResponse<>(true, "User deleted successfully.", null);
	}


}
