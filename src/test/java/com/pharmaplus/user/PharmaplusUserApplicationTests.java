package com.pharmaplus.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pharmaplus.user.entity.User;
import com.pharmaplus.user.repository.UserRepository;

@SpringBootTest
class PharmaplusUserApplicationTests {

	@Autowired
	UserRepository userRepository;
	
	/*@Test
	public void testAddUser() {
		User user = new User("", "Zek", "Cross", "zekcross", "zekcross@gmail.com", "zekcross", "American", "NBA Player", false, );
		userRepository.save(user);
	}*/
	
	@Test
	public void testFindUser() {
		User user = userRepository.findById("643ae2239a955977e274c8ce").get();
		System.out.println(user);
	}
	
	@Test
	public void testUpdate() {
		User user = userRepository.findById("643ae2239a955977e274c8ce").get();
		user.setFirstName("Tarik");
		userRepository.save(user);
	}
	
	@Test
	public void testDeleteUser(){
		User user = userRepository.findById("643adfd99a4c1d03ecf212ca").get();
		userRepository.delete(user);
	}

}
