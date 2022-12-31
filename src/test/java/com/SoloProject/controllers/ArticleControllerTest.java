package com.SoloProject.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.ui.Model;

import com.SoloProject.model.Article;
import com.SoloProject.service.ArticleService;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ArticleControllerTest {

	ArticleController articleController;
	
	@Mock
	ArticleService mockArticleService;
	
	@Mock
	HttpSession mockSession;
	
	@Mock
	Model mockModel;
	
	@BeforeEach
	public void setup() {
		articleController = new ArticleController(mockArticleService);
	}
	
	@Test
	public void test_searchForArticles() {
		
		List<Article> list = new ArrayList<>();
		List<Article> list2 = new ArrayList<>();
		List<Article> list3 = new ArrayList<>();
		String header = null;
		
		when(mockArticleService.getNewApi("politics", mockSession, false)).thenReturn(list);
		when(mockArticleService.getNewApi("entertainment", mockSession, true)).thenReturn(list2);
		when(mockArticleService.getNewApi("tech", mockSession, true)).thenReturn(list3);

		String result = articleController.searchForArticles(mockModel, mockSession, header);
		
		verify(mockModel, times(1)).addAttribute("header", "TODAY");

		
		assertEquals(ArticleController.DISPLAY_SEARCHED_ARTICLES, result);
	}
	

	
}
