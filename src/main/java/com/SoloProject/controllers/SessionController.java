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
 * Session controller is used to control user sessions (e.g. logging in and out)
 * 
 * @author Power.Tam
 * @version 2.0
 */

@Controller
public class SessionController {
	
	static final String HOME = "home";
	static final String CONFIRMATION = "confirmation";
	static final String DISPLAY_SEARCHED_ARTICLES = "newExploreArticles";
	static final String LOGIN = "newLogin";
	private UserService userService;
	private ArticleController articleController;
	
	
	@Autowired
	public SessionController(UserService userService, ArticleController articleController) {
		super();
		this.userService = userService;
		this.articleController = articleController;
	}

	@RequestMapping("/goToLoginPage")
	public String getLoginPage(Model model, HttpSession session) {
		
		User tempUser = new User();
		model.addAttribute("tempUser", tempUser);
		
		return LOGIN;
	}
	
	@RequestMapping("/processLogin")
	public String processLogin(@RequestParam("username") String username, 
			@RequestParam("password") String password, HttpSession session, Model model) {
		
		User user = userService.findByUsernameAndPassword(username, password);
		
		if(user != null) {
			session.setAttribute("currentUser", user);
			return articleController.searchForArticles(model, session, null);
		}
		else {
			model.addAttribute("error", "Invalid username and/or password");
			return LOGIN;
		}
	}
	
	@RequestMapping("/processLogout")
	public String processLogout(Model model, HttpSession session) {
		
		session.removeAttribute("currentUser");
		return articleController.searchForArticles(model, session, null);
	}
	
}
