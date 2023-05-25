package com.pharmaplus.user.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.pharmaplus.user.entity.Right;

public interface RightRepository extends MongoRepository<Right, String>{

	List<Right> findByName(String name);
}
