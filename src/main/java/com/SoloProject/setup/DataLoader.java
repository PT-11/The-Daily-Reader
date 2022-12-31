package com.SoloProject.setup;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.SoloProject.model.User;
import com.SoloProject.service.UserService;


@Component
public class DataLoader implements ApplicationRunner{

	private UserService userService;
	
	private Log log = LogFactory.getLog(DataLoader.class);
	
	@Autowired
	public DataLoader(UserService userService) {
		super();
		this.userService = userService;
	}

	@Override
	@Transactional
	@Modifying
	public void run(ApplicationArguments args) throws Exception {
		
		User user = new User("admin", "admin", "admin", "admin", "admin@gmail.com");
		
		userService.save(user);
		

		log.info("http://localhost:8088/SpringApp/");
		
		
	}

}
