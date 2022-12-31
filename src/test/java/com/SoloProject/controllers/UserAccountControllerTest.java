package com.SoloProject.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import com.SoloProject.model.User;
import com.SoloProject.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserAccountControllerTest {
	
	UserAccountController userAccountController;
	
	@Mock
	UserService mockUserService;
	
	@Mock
	HttpSession mockSession;
	
	@Mock
	Model mockModel;
	
	@Mock
	ArticleController mockArticleController;
	
	@Mock
	User mockUser;
	
	User user;
	
	@BeforeEach
	public void setup() {
		userAccountController = new UserAccountController(mockUserService, mockArticleController);
		user = new User();
	}
	
	@Test
	public void test_goToRegisterPage() {
		String result = userAccountController.goToRegisterPage(mockModel, mockSession);

		verify(mockModel, times(1)).addAttribute(eq("user"), any(User.class));
		assertEquals(UserAccountController.REGISTER, result);
	}
	
	@Test
	public void test_registerUser_available_name() {
		
		when(mockUserService.checkUsernameTaken(user.getUsername())).thenReturn(false);
		
		String result = userAccountController.registeruser(user, mockSession, mockModel);
		
		InOrder order = inOrder(mockUserService, mockSession, mockArticleController);
		order.verify(mockUserService, times(1)).checkUsernameTaken(eq(user.getUsername()));
		order.verify(mockUserService, times(1)).save(user);
		order.verify(mockSession, times(1)).setAttribute("currentUser", user);
		order.verify(mockArticleController, times(1)).searchForArticles(mockModel, mockSession, null);
		assertEquals(null, result);
		
	}
	
	@Test
	public void test_registerUser_username_taken() {
		
		when(mockUserService.checkUsernameTaken(user.getUsername())).thenReturn(true);
		
		String result = userAccountController.registeruser(user, mockSession, mockModel);
		
		InOrder order = inOrder(mockUserService, mockModel);
		order.verify(mockUserService, times(1)).checkUsernameTaken(user.getUsername());
		order.verify(mockModel, times(1)).addAttribute(eq("error"), eq("Username already in use"));
		assertEquals(UserAccountController.REGISTER, result);
	}
	
	
	
	
	
	
	
	


}
