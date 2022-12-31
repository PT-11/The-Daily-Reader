package com.SoloProject.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.SoloProject.model.User;
import com.SoloProject.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	UserService userService;
	
	@Mock
	UserRepository mockUserRepo;
	
	User user;
	
	@Spy
	User user2 = new User();
	
	@Spy
	UserService userService2 = new UserService(mockUserRepo);
	
	@BeforeEach
	public void setup() {
		userService = new UserService(mockUserRepo);
		user = new User("user", "fname", "lname", "pw", "email");

	}
	
	@Test
	public void test_save() {
		
		when(mockUserRepo.save(user)).thenReturn(user);
		
		User resultUser = userService.save(user);
		
		verify(mockUserRepo, times(1)).save(user);
		assertEquals(user, resultUser);
	}
	
	@Test
	public void test_findByUsernameAndPassword() {
		
		String username = "user101";
		String password = "pass";
		when(mockUserRepo.findByUsernameAndPassword(username, password)).thenReturn(user);
		
		User resultUser = userService.findByUsernameAndPassword(username, password);
		
		verify(mockUserRepo, times(1)).findByUsernameAndPassword(username, password);
		assertEquals(user, resultUser);
	}
	
	@Test
	public void test_checkUsernameTaken_true() {
		
		String username = "fakeusername";
		when(mockUserRepo.findByUsername(username)).thenReturn(user);
		
		boolean result = userService.checkUsernameTaken(username);
		
		verify(mockUserRepo, times(1)).findByUsername(username);
		assertEquals(true, result);
		
	}
	
	@Test
	public void test_checkUsernameTaken_false() {
		String username = "fakeusername";
		when(mockUserRepo.findByUsername(username)).thenReturn(null);
		
		boolean result = userService.checkUsernameTaken(username);
		
		verify(mockUserRepo, times(1)).findByUsername(username);
		assertEquals(false, result);
	}
	
	@Test
	public void test_updateUser() {
		String firstname = "fname";
		String lastname = "lname";
		String password = "pw";
		
		
		
		
		User resultUser = userService.updateUser(user2, firstname, lastname, password);
		
		InOrder order = inOrder(user2);
		
		order.verify(user2, times(1)).setfName(firstname);
		order.verify(user2, times(1)).setlName(lastname);
		order.verify(user2, times(1)).setPassword(password);
		assertEquals(user2, resultUser);
				
	}
	
	@Test
	public void test_removeUser() {
		
		userService.remove(user);
		
		verify(mockUserRepo, times(1)).deleteById(user.getId()); 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
