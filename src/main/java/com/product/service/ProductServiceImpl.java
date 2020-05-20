package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.product.controller.exception.ProductNotfoundException;
import com.product.model.Product;
import com.product.repositroy.ProductRepositroy;

@Service
@Transactional

public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepositroy productRepositroy;

	@Override
	public List<Product> getAllProducts() {

		return (List<Product>) productRepositroy.findAll();
	}

	@Override
	public Product addProduct(Product product) {

		return productRepositroy.save(product);
	}

	@Override
	public Product getProductById(int productId) {

		return productRepositroy.getOne(productId);
	}

	@Override
	public Product updateProduct(Product product) {

		return productRepositroy.save(product);
	}

	@Override
	public void deleteProduct(int productId) {
		productRepositroy.deleteById(productId);

	}

	@Override
	public Product getProductByName(String name) {

		Product product = productRepositroy.getProductByName(name);
		if (product != null) {
			return product;
		} else {
			throw new ProductNotfoundException();
		}
	}

	@Override
	public List<Product> getProductByNameStartingWith(String name) {

		return productRepositroy.getProductByNameStartingWith(name);
	}

	@Override
	public Product getProductByNameAndPrice(String name, double price) {

		return productRepositroy.getProductByNameAndPrice(name, price);
	}

	@Override
	public Product getProductByPrice(double price) {

		Product product = productRepositroy.getProductByPrice(price);
		if (product != null) {
			return product;
		} else {
			throw new ProductNotfoundException();
		}
	}

}
