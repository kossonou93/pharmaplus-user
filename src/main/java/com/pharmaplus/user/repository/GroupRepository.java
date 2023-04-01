package com.pharmaplus.user.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.pharmaplus.user.entity.Group;

public interface GroupRepository extends MongoRepository<Group, String>{
	List<Group> findByName(String name);
}
