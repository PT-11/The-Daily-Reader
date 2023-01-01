package com.SoloProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SoloProject.model.Article;
import com.SoloProject.model.User;
import com.SoloProject.repository.UserRepository;

@Service
public class SavedArticleService {
	private UserRepository userRepo;
	
	@Autowired
	public SavedArticleService(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	public void save(String title, String url, String urlToImage, String description, int userId) {
		
		User user = userRepo.getById(userId);
		
		user.add(new Article(title, url, urlToImage, description));
		
		userRepo.save(user);
	}

	public List<Article> getSavedList(int id) {
		
		User user = userRepo.getById(id);
		return user.getSavedArticles();
		
	}

	public void delete(String articleUrl, User currentUser) {
		
		currentUser.deleteArticle(articleUrl);
		
		userRepo.save(currentUser);
	}
}
