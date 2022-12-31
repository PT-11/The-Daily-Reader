package com.SoloProject.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SoloProject.model.User;
import com.SoloProject.service.UserService;

/**
 * UserAccountController manages user accounts
 * Not required in current application.
 * @author Power.Tam
 * @version 2.0
 */

@Controller
public class UserAccountController {
	
	static final String REMOVE_USER = "removeUser";
	static final String UPDATE_USER = "updateUser";
	static final String HOME = "home";
	static final String CHECK_USER = "checkUser";
	static final String CONFIRMATION = "confirmation";
	static final String REGISTER = "newRegister";
	private UserService userService;
	private ArticleController articleController;
	
	
	@Autowired
	public UserAccountController(UserService userService, ArticleController articleController) {
		this.userService = userService;
		this.articleController = articleController;
	}

	@RequestMapping("/goToRegisterPage")
	public String goToRegisterPage(Model model, HttpSession session) {
           
		model.addAttribute("user", new User());

		return REGISTER;
	}
	
	@RequestMapping("/processUser")
	public String registeruser(User user, HttpSession session, Model model) {
		
		if(userService.checkUsernameTaken(user.getUsername())) {
			model.addAttribute("error", "Username already in use");
			
			return REGISTER;
			
		} else {
			userService.save(user);
			session.setAttribute("currentUser", user);
			return articleController.searchForArticles(model, session, null);
		}
		
	}
	

}
