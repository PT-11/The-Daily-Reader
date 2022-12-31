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
		
		List<Article> list1 = new ArrayList<>();
		List<Article> list2 = new ArrayList<>();
		List<Article> list3 = new ArrayList<>();
		List<Article> temp = articleService.getNewApi(null, session, false);
		
		for (Article article : temp) {
			list1.add(article);
		}
				
		temp = articleService.getNewApi("politics", session, true);
		
		for (Article article : temp) {
			list2.add(article);
		}
		
		temp = articleService.getNewApi("entertainment", session, true);
		
		for (Article article : temp) {
			list3.add(article);
		}
		temp = articleService.getNewApi("tech", session, false);
		
		for (Article article : temp) {
			list1.add(article);
		}
		
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
		
		List<Article> tempList = new ArrayList<>();
		
		for (Article article : articleService.getSearchResults(topic, session, false)) {
			tempList.add(article);
		}
		
		for (Article article : articleService.getSearchResults(topic, session, true)) {
			tempList.add(article);
		}
		
		session.setAttribute("list", tempList);
		model.addAttribute("header", header);
		return DISPLAY_SEARCHED_ARTICLES;
			
	}
	

}
