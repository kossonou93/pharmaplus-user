package com.pharmaplus.user.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pharmaplus.user.entity.UserRight;
import com.pharmaplus.user.exception.NotFoundException;
import com.pharmaplus.user.repository.UserRightRepository;
import com.pharmaplus.user.utility.ApiResponse;

@RestController
@RequestMapping(value = "/pharmaplus/user-right")
public class UserRightContoller {
	
	@Autowired
	UserRightRepository userRightRepository;
	
	// Get all UserRight
		@GetMapping("/all")
		public ApiResponse<List<UserRight>> getUserRights() {
			List<UserRight> userRights = userRightRepository.findAll();
			return new ApiResponse<>(true, "UserRights found successfully.", userRights);
		}
		
		// Add UserRight
		@PostMapping("/add")
		public ApiResponse<UserRight> addUserRight(@RequestBody UserRight userRight) {
			UserRight savedUserRight = userRightRepository.save(userRight);
	        return new ApiResponse<>(true, "UserRight save Successfully.", savedUserRight);
		}
		
		// Get UserRight By Id
		@GetMapping("/id/{id}")
		public ApiResponse<UserRight> getUserRightById(@PathVariable String id) throws NotFoundException{
			UserRight userRight = userRightRepository.findById(id).orElseThrow(() -> new NotFoundException("UserRight not found for this id :: " + id));
			return new ApiResponse<>(true, "UserRight found successfully.", userRight);
		}
		
		// Update UserRight By Id
		@PutMapping("/{id}")
		public ApiResponse<UserRight> updateUserRight(@PathVariable("id") String id, @RequestBody UserRight userRight) throws NotFoundException{
		    UserRight updatedUserRight = userRightRepository.findById(id).orElseThrow(() -> new NotFoundException("UserRight not found for this id :: " + id));
		    updatedUserRight.setIdRight(userRight.getIdRight());
		    updatedUserRight.setIdUser(userRight.getIdUser());
		    updatedUserRight.setRole(userRight.getRole());
		    return new ApiResponse<>(true, "UserRight updated successfully.", updatedUserRight);
		}
		
		// Delete UserRight By Id
		@DeleteMapping("/{id}")
		public ApiResponse<Void> deleteUserRight(@PathVariable("id") String id) {
		    userRightRepository.deleteById(id);
		    return new ApiResponse<>(true, "UserRight deleted successfully.", null);
		}

}
