package com.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner.Silent;

import com.product.model.Login;
import com.product.repositroy.UserLoginRepositroy;

@RunWith(Silent.class)
public class UserLoginServiceTest {
	@InjectMocks
	UserLoginService userloginService;
	@Mock
	UserLoginRepositroy userloginRepositroy;
	static Login login=null;
	@BeforeClass
	public static void setUp() {
		login=new Login();
	}
	@Test
	public void testForAddtheuser() {
		List<Login> users = new ArrayList();
		login.setId(2);
		login.setName("abc");
		login.setPassword("1234");
		users.add(login);
		Mockito.when(userloginRepositroy.getOne(Mockito.anyInt())).thenReturn(login);
		Login user1 = userloginService.addUser(login);
		Assert.assertEquals(1, users.size());
		
	}
	@Test
	public void testForFingByname() {
		login.setId(4);
		login.setName("sam");
		Mockito.when(userloginRepositroy.findByName(Mockito.anyString())).thenReturn(Optional.of(login));
	     login=userloginService.loginuser(login);
	     Assert.assertNotNull(login);
	     Assert.assertEquals("sam", login.getName());
	}
    @Test
	public void testForFingBynameNegitive() {
		login.setId(4);
		login.setName("-sam");
		Mockito.when(userloginRepositroy.findByName(Mockito.anyString())).thenReturn(Optional.of(login));
	     login=userloginService.loginuser(login);
	     Assert.assertNotNull(login);
	     Assert.assertEquals("-sam", login.getName());
	}

}
