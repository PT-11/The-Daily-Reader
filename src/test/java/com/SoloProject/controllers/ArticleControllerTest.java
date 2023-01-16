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
		
		String header = null;

		String result = articleController.searchForArticles(mockModel, mockSession, header);

		
		assertEquals(ArticleController.DISPLAY_SEARCHED_ARTICLES, result);
	}
	

	
}
