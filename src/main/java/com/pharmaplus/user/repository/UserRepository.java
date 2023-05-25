package com.pharmaplus.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.pharmaplus.user.entity.User;

public interface UserRepository extends MongoRepository<User, String>{

	List<User> findByFirstName(String firstName);
	List<User> findByFirstNameContains(String firstName);
	Optional<User> findByUsername(String username);
}
