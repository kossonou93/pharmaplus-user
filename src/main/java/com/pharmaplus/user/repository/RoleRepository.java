package com.pharmaplus.user.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.pharmaplus.user.entity.Role;

public interface RoleRepository extends MongoRepository<Role, String>{
	
	Optional<Role> findByName(String name);

}
