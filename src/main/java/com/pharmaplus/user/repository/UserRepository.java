package com.pharmaplus.user.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.pharmaplus.user.entity.User;

public interface UserRepository extends MongoRepository<User, String>{

	List<User> findByNom(String nom);
}
