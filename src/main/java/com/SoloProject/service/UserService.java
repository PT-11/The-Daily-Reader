package com.SoloProject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SoloProject.model.User;
import com.SoloProject.repository.UserRepository;

/**
 * UserService contains application logic
 * 
 * @author Power.Tam
 * @version 2.0
 */
@Service
public class UserService {


	private UserRepository userRepo;

	@Autowired
	public UserService(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}
	
	public User save(User user) {
		return userRepo.save(user);
	}
	
	public User findByUsernameAndPassword(String username, String password) {
		
		return userRepo.findByUsernameAndPassword(username, password);
	}
	
	public boolean checkUsernameTaken(String username) {
		
		if(userRepo.findByUsername(username) != null) {
			return true;
		}
		else {
			return false;
		}
	}

	public User updateUser(User currentUser, String firstname, String lastname, String password) {
		currentUser.setfName(firstname);
		currentUser.setlName(lastname);
		currentUser.setPassword(password);
		save(currentUser);
		
		return currentUser;
		
	}

	public void remove(User user) {
		userRepo.deleteById(user.getId());
		
	}


	
	
}
