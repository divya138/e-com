package com.product.repositroy;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.model.Login;

public interface UserLoginRepositroy extends JpaRepository<Login, Integer> {
	Optional<Login> findByName(String name);

	public Login findByNameAndPassword(String name, String password);

}
