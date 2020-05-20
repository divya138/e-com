package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Login;
import com.product.service.UserLoginService;
@RestController
public class loginController {
	@Autowired
	UserLoginService userloginservice;

	@PostMapping("/login5")
	ResponseEntity<Login> login(@RequestBody Login login) {
		Login login1 = userloginservice.loginuser(login);
		return new ResponseEntity<Login>(login1, HttpStatus.OK);

	}

	@GetMapping("/login5")
	public boolean loginValidation(@RequestParam String name) {
		boolean login = userloginservice.loginValidation(name);
		return login;

	}
}
