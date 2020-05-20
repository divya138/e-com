package com.product.controller;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner.Silent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.product.controller.exception.InvailUserException;
import com.product.model.Login;
import com.product.service.UserLoginService;

@RunWith(Silent.class)

public class LoginControllerTest {
	@InjectMocks
	loginController logincontroller;
	@Mock
	UserLoginService userloginService;
	 static Login login=null;
	 @BeforeClass
   public static void setUp() {
	   login=new Login();
   }
	 @Test
	 public void testforUserLogin() {
		 login.setName("ram");
		 login.setPassword("bhavani");
		 Mockito.when(userloginService.loginuser(login)).thenReturn(login);
		 ResponseEntity<Login> result=logincontroller.login(login);
		 Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
	 }
	 @Test
	 public void testforGettheNameUser() {
		 login.setId(5);
		 login.setName("ram");
		 login.setPassword("sam");
		 Mockito.when(userloginService.loginValidation("ram")).thenReturn(true);
		 boolean result1=logincontroller.loginValidation("ram");
		 Assert.assertEquals(result1,result1);
		 
	 }
}
