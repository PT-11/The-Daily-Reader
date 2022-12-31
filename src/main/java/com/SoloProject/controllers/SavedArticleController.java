package com.SoloProject.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SoloProject.model.Article;
import com.SoloProject.model.User;
import com.SoloProject.repository.UserRepository;
import com.SoloProject.service.SavedArticleService;

@Controller
public class SavedArticleController {
	

	static final String VIEW_SAVED_ARTICLES = "viewSavedArticles";
	static final String DISPLAY_SEARCHED_ARTICLES = "newExploreArticles";
	private SavedArticleService savedArticleService;
	private UserRepository userRepo;
	
	@Autowired
	public SavedArticleController(SavedArticleService savedArticleService, UserRepository userRepo) {
		super();
		this.savedArticleService = savedArticleService;
		this.userRepo = userRepo;
	}
	
	@RequestMapping("/saveArticle")
	public String saveArticle(@RequestParam("title") String title, @RequestParam("url") String url, @RequestParam("urlToImage") String urlToImage,
			@RequestParam("desc") String desc, HttpSession session) {
		

		User currentUser = (User) session.getAttribute("currentUser");
		
		Article article = new Article(title, url, urlToImage, desc);
		
		article.setUser(currentUser);
		
		currentUser.add(article);
		
		userRepo.save(currentUser);
		
		return DISPLAY_SEARCHED_ARTICLES;
	}

	@RequestMapping("/deleteArticle")
	public String deleteArticle(@RequestParam("url") String url, HttpSession session) {

		User currentUser = (User) session.getAttribute("currentUser");
		
		savedArticleService.delete(url, currentUser);

		return VIEW_SAVED_ARTICLES;
	}
	
	@RequestMapping("/viewSavedArticles")
	public String viewSavedArticles(Model model, HttpSession session) {
		
		User currentUser = (User) session.getAttribute("currentUser");
		
		if (currentUser.getSavedArticles().isEmpty()) {
			model.addAttribute("noSavedArticles", "You currently have no saved articles."
					+ "\n Feel free to save articles from these trending stories by heading back to the home page "
					+ "\n or browse for your own using the search bar.");
		}
		

		
		session.setAttribute("savedList", currentUser.getSavedArticles());
		
		return VIEW_SAVED_ARTICLES;		
	}	
	
}
