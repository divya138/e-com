package com.product.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userLogin")
public class Login {
	@Id
	private int id;
	private String name;
	private String password;
	private boolean isLogin;

	public Login(int id, String name, String password, boolean isLogin) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.isLogin = isLogin;
	}

	public Login(String name, String password, boolean isLogin) {
		super();
		this.name = name;
		this.password = password;
		this.isLogin = isLogin;
	}

	public Login() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

}
