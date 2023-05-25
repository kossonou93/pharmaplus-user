package com.pharmaplus.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.pharmaplus.user.exception.NotFoundException;
import com.pharmaplus.user.repository.RoleRepository;
import com.pharmaplus.user.service.UserService;
import jakarta.annotation.PostConstruct;

//@EnableWebSecurity
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class PharmaplusUserApplication {

	//@Autowired
	//RoleServiceImpl roleServiceImpl;
	
	@Autowired
	UserService userService;
	
	@Autowired
	private RoleRepository roleRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(PharmaplusUserApplication.class, args);
	}
	
	/*@PostConstruct
    public void init() {
		roleServiceImpl.saveRole();
	}*/
	
	@Bean
	BCryptPasswordEncoder getBCE() {
	return new BCryptPasswordEncoder();
	}
	
	@PostConstruct
	void init_users() throws NotFoundException {
		/*Role admin = new Role("ADMIN");
		Role caissiere = new Role("CAISSIERE");
		Role charger = new Role("CHARGER_DE_COMMANDE");
		Role comptable = new Role("COMPTABLE");
		Role gestion_fact = new Role("GESTIONNAIRE_FACTURE");
		Role gestion_stc = new Role("GESTIONNAIRE_STOCK");
		Role pharmacien = new Role("PHARMACIEN");
		Role super_admin = new Role("SUPER_ADMIN");
		Role tb = new Role("TABLEAU_DE_BORD");
		Role user = new Role("USER");
		roleRepository.saveAll(Arrays.asList(admin, caissiere, charger, comptable, gestion_fact, gestion_stc, pharmacien, super_admin, tb, user));
		User usr = new User("", "Koss", "Karl", "kossonou93", "kossonou93@gmail.com", "123", "Ivoirienne", "Dev", true);
		userService.saveUser(usr);
		userService.addRoleToUser("kossonou93", "ADMIN");*/
	}

}
