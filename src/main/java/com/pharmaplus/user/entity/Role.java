package com.pharmaplus.user.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
	
	@Id
	private String id;

	private String name;
	
	public Role(String name) {
		this.name = name;
	}

}
