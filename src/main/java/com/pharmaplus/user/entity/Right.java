package com.pharmaplus.user.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("right")
public class Right {

	@Id
	private String id;
	private String name;
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
	public Right() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Right(String name) {
		super();
		this.name = name;
	}
}
