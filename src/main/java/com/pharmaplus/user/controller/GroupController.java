package com.pharmaplus.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.pharmaplus.user.exception.NotFoundException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pharmaplus.user.entity.Group;
import com.pharmaplus.user.repository.GroupRepository;
import com.pharmaplus.user.utility.ApiResponse;

@CrossOrigin
@RestController
@RequestMapping(value = "/pharmaplus/group")
public class GroupController {
	
	@Autowired
	GroupRepository groupRepository;
	
	// Get all group
	@GetMapping("/all")
	public ApiResponse<List<Group>> getGroups() {
		List<Group> groups = groupRepository.findAll();
		return new ApiResponse<>(true, "Groups found successfully.", groups);
	}

	// Add Group
	@PostMapping("/add")
	public ApiResponse<Group> addGroup(@RequestBody Group group) {
		Group savedGroup = groupRepository.save(group);
        return new ApiResponse<>(true, "Group save Successfully.", savedGroup);
	}
	
	//@Transactional
	@GetMapping("/id/{id}")
	public ApiResponse<Group> getGroupById(@PathVariable String id) throws NotFoundException{
		Group group = groupRepository.findById(id).orElseThrow(() -> new NotFoundException("Group not found for this id :: " + id));
		return new ApiResponse<>(true, "Group found successfully.", group);
	}
	
	@GetMapping("/name/{name}")
    public ApiResponse<List<Group>> getGroupByName(@PathVariable String name) throws NotFoundException{
        // Logic to retrieve a group by Name from the database
		List<Group> group = groupRepository.findByName(name);
		return new ApiResponse<>(true, "Group found successfully.", group);
    }
	
	// Update Group By Id
	@PutMapping("/{id}")
    public ApiResponse<Group> updateGroupById(@PathVariable String id, @RequestBody Group group) throws NotFoundException{
		Group existingGroup = groupRepository.findById(id).orElseThrow(() -> new NotFoundException("Group not found for this id :: " + id));
		existingGroup.setName(group.getName());
		groupRepository.save(group);
        return new ApiResponse<>(true, "Group updated successfully.", existingGroup);
    }

	// Delete Group By Id
	@DeleteMapping("/{id}")
	public ApiResponse<Void> deleteGroup(@PathVariable("id") String id) {
	    groupRepository.deleteById(id);
	    return new ApiResponse<>(true, "Group deleted successfully.", null);
	}
}
