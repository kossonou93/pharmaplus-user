package com.pharmaplus.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharmaplus.user.entity.Right;
import com.pharmaplus.user.exception.NotFoundException;
import com.pharmaplus.user.repository.RightRepository;
import com.pharmaplus.user.utility.ApiResponse;

@CrossOrigin
@RestController
@RequestMapping(value = "/pharmaplus/right")
public class RightController {

	@Autowired
	RightRepository rightRepository;
	
	// Get all Right
		@GetMapping("/all")
		public ApiResponse<List<Right>> getUsers() {
			List<Right> rights = rightRepository.findAll();
			return new ApiResponse<>(true, "Rights found successfully.", rights);
		}
		
		// Add Right
		@PostMapping("/add")
		public ApiResponse<Right> addUser(@RequestBody Right right) {
			Right savedRight = rightRepository.save(right);
	        return new ApiResponse<>(true, "Right save Successfully.", savedRight);
		}
		
		// Get Right By Id
		@GetMapping("/id/{id}")
		public ApiResponse<Right> getUserById(@PathVariable String id) throws NotFoundException{
			Right right = rightRepository.findById(id).orElseThrow(() -> new NotFoundException("Right not found for this id :: " + id));
			return new ApiResponse<>(true, "User found successfully.", right);
		}
		
		// Update User By Id
		@PutMapping("/{id}")
		public ApiResponse<Right> updateUser(@PathVariable("id") String id, @RequestBody Right right) throws NotFoundException{
			Right updatedRight = rightRepository.findById(id).orElseThrow(() -> new NotFoundException("Right not found for this id :: " + id));
		    updatedRight.setName(right.getName());
		    return new ApiResponse<>(true, "User updated successfully.", updatedRight);
		}
		
		// Delete Right By Id
		@DeleteMapping("/{id}")
		public ApiResponse<Void> deleteRight(@PathVariable("id") String id) {
			rightRepository.deleteById(id);
		    return new ApiResponse<>(true, "Right deleted successfully.", null);
		}
}
