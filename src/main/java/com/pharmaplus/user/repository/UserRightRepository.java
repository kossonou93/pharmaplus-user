package com.pharmaplus.user.repository;

import java.util.List;
import com.pharmaplus.user.entity.UserRight;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRightRepository extends MongoRepository<UserRight, String> {
	List<UserRight> findByRole(String role);

}
