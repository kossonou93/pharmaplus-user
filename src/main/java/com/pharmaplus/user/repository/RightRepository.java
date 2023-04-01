package com.pharmaplus.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pharmaplus.user.entity.Right;

public interface RightRepository extends MongoRepository<Right, String>{

}
