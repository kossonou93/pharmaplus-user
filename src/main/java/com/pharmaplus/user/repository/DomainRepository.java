package com.pharmaplus.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pharmaplus.user.entity.Domain;

public interface DomainRepository extends MongoRepository<Domain, String>{

}
