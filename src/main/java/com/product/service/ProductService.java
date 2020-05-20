package com.product.service;

import java.util.List;
import com.product.model.Product;

public interface ProductService {
	public List<Product> getAllProducts();

	public Product addProduct(Product product);

	public Product getProductById(int productId);

	public Product updateProduct(Product product);

	public void deleteProduct(int productId);

	public Product getProductByName(String name);

	public List<Product> getProductByNameStartingWith(String name);

	public Product getProductByNameAndPrice(String name, double price);

	public Product getProductByPrice(double price);

}
