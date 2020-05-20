package com.product.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.model.Login;
import com.product.repositroy.UserLoginRepositroy;

@Service
public class UserLoginService {
	@Autowired
	UserLoginRepositroy userloginRepositroy;

	public boolean loginValidation(String name) {
		Optional<Login> optional = userloginRepositroy.findByName(name);
		if (optional.isPresent()) {
			Login user1 = optional.get();
			if (user1.isLogin() == false) {
				return false;
			}
			if (user1.isLogin() == true) {
				return true;
			}
		}
		return false;
	}

	public Login loginuser(Login login) {
		Optional<Login> option = userloginRepositroy.findByName(login.getName());
		Login user1 = null;
		if (option.isPresent()) {
			user1 = option.get();
			user1.setLogin(true);
			userloginRepositroy.save(user1);
		}
		return user1;

	}

	public Login addUser(Login login) {
		
		return userloginRepositroy.save(login);
	}
}
