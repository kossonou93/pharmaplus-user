package com.pharmaplus.user.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Document("user")
public class User {
	
	@Id
	private String id;
	private String idGroup;
	private String firstName;
	private String lastName;
	//@Column(unique = true)
	private String username;
	@Column(unique = true)
	private String email;
	private String password;
	private String civi;
	private String fonction;
	private Boolean enable;
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name="role_id"))
	private List<Role> roles;
	public User(String idGroup, String firstName, String lastName, String username, String email, String password,
			String civi, String fonction, Boolean enable) {
		super();
		this.idGroup = idGroup;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
		this.civi = civi;
		this.fonction = fonction;
		this.enable = enable;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
