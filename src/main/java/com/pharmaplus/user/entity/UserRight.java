package com.pharmaplus.user.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user_right")
public class UserRight {
	
	@Id
	private String id;
	private String idRight;
	private String idUser;
	private String role;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdRight() {
		return idRight;
	}
	public void setIdRight(String idRight) {
		this.idRight = idRight;
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public UserRight() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserRight(String idRight, String idUser, String role) {
		super();
		this.idRight = idRight;
		this.idUser = idUser;
		this.role = role;
	}
}
