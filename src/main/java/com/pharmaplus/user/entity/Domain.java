package com.pharmaplus.user.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Domain")
public class Domain {
	
	@Id
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String name;
	public Domain() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Domain(String name) {
		super();
		this.name = name;
	}
	
}
