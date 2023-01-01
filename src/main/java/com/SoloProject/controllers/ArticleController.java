package com.SoloProject.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SoloProject.model.Article;
import com.SoloProject.service.ArticleService;

@Controller
public class ArticleController {
	
	static final String DISPLAY_SEARCHED_ARTICLES = "newExploreArticles";
	private ArticleService articleService;
	
	@Autowired
	public ArticleController(ArticleService articleService) {
		super();
		this.articleService = articleService;
	}
	
	@RequestMapping(value={"/searchForArticles", "/"})
	public String searchForArticles(Model model, HttpSession session, String header) {
		
		List<Article> list1 = new ArrayList<>(articleService.getNewApi(null, session, false));
			
		List<Article> list2 = new ArrayList<>(articleService.getNewApi("politics", session, true));
		
		List<Article> list3 = new ArrayList<>(articleService.getNewApi("entertainment", session, true));
		
		list1.addAll(articleService.getNewApi("tech", session, false));		
		
		if (header == null) {
			header = "TODAY";
		}
		
		model.addAttribute("header", header);
		
		session.setAttribute("list", list1);
		session.setAttribute("trendList", list2);
		session.setAttribute("recentList", list3);
		return DISPLAY_SEARCHED_ARTICLES;
	}
	
	@RequestMapping("/searchForTopic")
	public String searchForTopic(@RequestParam("topic") String topic, HttpSession session, Model model) {
		
		String header = "Search results for: " + topic;
		
		List<Article> searchResults = new ArrayList<>(articleService.getSearchResults(topic, session, false));
		
		searchResults.addAll(articleService.getSearchResults(topic, session, true));
		
		session.setAttribute("list", searchResults);
		model.addAttribute("header", header);
		return DISPLAY_SEARCHED_ARTICLES;
			
	}
	

}
