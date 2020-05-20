package com.product.repositroy;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.model.Product;

public interface ProductRepositroy extends JpaRepository<Product, Integer> {
	public Product getProductByName(String name);

	public Product getProductByNameAndPrice(String name, double price);

	public Product getProductByPriceOrDate(double price, LocalDate date);

	public List<Product> getProductByNameStartingWith(String name);

	public Product getProductByPrice(double price);

}
