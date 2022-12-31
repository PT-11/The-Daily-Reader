package com.SoloProject.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import com.SoloProject.model.Article;
import com.SoloProject.model.User;
import com.SoloProject.repository.UserRepository;
import com.SoloProject.service.SavedArticleService;

@ExtendWith(MockitoExtension.class)
public class SavedArticleControllerTest {
	
	SavedArticleController savedArticleController;
	
	@Mock
	SavedArticleService mockSavedArticleService;
	
	@Mock
	HttpSession mockSession;
	
	@Mock
	UserRepository mockUserRepo;
	
	@Mock
	User mockUser;
	
	@Mock
	Model mockModel;
	
	@Mock
	Article mockArticle;
	
	@Mock
	List<Article> mockList;
	
	@BeforeEach
	public void setup() {
		savedArticleController = new SavedArticleController(mockSavedArticleService, mockUserRepo);
	}
	
	@Test
	public void test_saveArticle() {
		
		String title = "testTitle";
		String url = "testUrl";
		String urlToImage = "testUrlToImage";
		String desc = "testDesc";
		
		when(mockSession.getAttribute("currentUser")).thenReturn(mockUser);
		
		String result = savedArticleController.saveArticle(title, url, urlToImage, desc, mockSession);
		
		verify(mockSession, times(1)).getAttribute("currentUser");
		verify(mockUser, times(1)).add(any(Article.class));
		verify(mockUserRepo, times(1)).save(mockUser);
		assertEquals(SavedArticleController.DISPLAY_SEARCHED_ARTICLES, result);
	}
	
	@Test
	public void test_viewSavedArticles() {
		
		User user = new User("username", "fname", "lName", "pw123", "email");
		user.setSavedArticles(mockList);
		ArrayList<Article> list = new ArrayList<Article>();
		list.add(mockArticle);
		when(mockSession.getAttribute("currentUser")).thenReturn(user);

		String result = savedArticleController.viewSavedArticles(mockModel, mockSession);
		
		verify(mockSession, times(1)).getAttribute("currentUser");

		assertEquals(SavedArticleController.VIEW_SAVED_ARTICLES, result);
		
	}
	
	@Test
	public void test_deleteSavedArticle() {
		
		String url = "fakeURL";
		when(mockSession.getAttribute("currentUser")).thenReturn(mockUser);
		
		
		String result = savedArticleController.deleteArticle(url, mockSession);
		
		verify(mockSavedArticleService, times(1)).delete(url, mockUser);
		
		assertEquals(SavedArticleController.VIEW_SAVED_ARTICLES, result);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
