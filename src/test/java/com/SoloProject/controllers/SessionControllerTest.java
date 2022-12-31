package com.SoloProject.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
public class SessionControllerTest {
	
	SessionController sessionController;
	
	@Mock
	UserService mockUserService;
	
	@Mock
	Model mockModel;
	
	@Mock
	ArticleController mockArticleController;
	
	@Mock
	HttpSession mockSession;
	

	
	@BeforeEach
	public void setup() {
		sessionController = new SessionController(mockUserService, mockArticleController);

	}
	
	@Test
	public void test_getLoginPage() {
		
		String result = sessionController.getLoginPage(mockModel, mockSession);
		assertEquals(SessionController.LOGIN, result); 
	}
	
	@Test
	public void test_processLogin_valid_username_and_password() {
		
		String username = "tempUsername";
		String password = "tempPassword";
		User user = new User("uname", "fname", "lname", "pw", "email");
				
		when(mockUserService.findByUsernameAndPassword(username, password)).thenReturn(user);
		
		String result = sessionController.processLogin(username, password, mockSession, mockModel);
		
		InOrder order = inOrder(mockSession, mockArticleController);
		
		order.verify(mockSession, times(1)).setAttribute("currentUser", user);
		order.verify(mockArticleController, times(1)).searchForArticles(mockModel, mockSession, null);
		assertEquals(null, result);
	}
	
	@Test
	public void test_processLogin_invalid_username_and_password() {
		
		String username = "tempUsername";
		String password = "tempPassword";
		
		when(mockUserService.findByUsernameAndPassword(username, password)).thenReturn(null);
		
		String result = sessionController.processLogin(username, password, mockSession, mockModel);
		
		verify(mockModel, times(1)).addAttribute(eq("error"), eq("Invalid username and/or password"));
		assertEquals(SessionController.LOGIN, result);
	}
	
	@Test
	public void test_processLogout() {
		
		String result = sessionController.processLogout(mockModel, mockSession);
		
		verify(mockSession, times(1)).removeAttribute(eq("currentUser"));
		assertEquals(null, result);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
