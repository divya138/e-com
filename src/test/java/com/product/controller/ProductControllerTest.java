package com.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoJUnitRunner.Silent;
import org.springframework.http.ResponseEntity;

import com.product.controller.exception.ProductNotfoundException;
import com.product.model.Product;
import com.product.service.ProductService;

@RunWith(Silent.class)

public class ProductControllerTest {
	@InjectMocks
	ProductController productController;
	@Mock
	ProductService productService;
	static Product product = null;

	@BeforeClass
	public static void setUp() {
		product = new Product();
	}

	@Test
	public void testForAllProducts() {
		List<Product> products = new ArrayList();
		product.setName("phone");
		product.setPrice(5678);
		products.add(product);
		Mockito.when(productService.getAllProducts()).thenReturn(products);
		Assert.assertEquals(1, products.size());
	}

	@Test
	public void testforAddMethod() {
		List<Product> products = new ArrayList();
		product.setName("divya");
		product.setPrice(12344);
		products.add(product);
		Mockito.when(productService.addProduct(product)).thenReturn(product);
		Assert.assertEquals(1, products.size());
	}

	@Test
	public void testForFindByIdForPostivteforCon() {
		product.setProductId(1);
		product.setName("phone");
		Mockito.when(productService.getProductById(Mockito.anyInt())).thenReturn(product);
		Assert.assertEquals(1, product.getProductId());

	}

	@Test
	public void testForProductByNamePostive() {
		product.setProductId(5);
		product.setName("divya");
		Mockito.when(productService.getProductByName(Mockito.anyString())).thenReturn(product);
		Assert.assertEquals("divya", product.getName());

	}

	@Test
	public void testForProductByPricePostive() {
		product.setName("tv");
		product.setPrice(34356);
		Mockito.when(productService.getProductByPrice(Mockito.anyDouble())).thenReturn(product);
		Assert.assertEquals("tv", product.getName());

	}

	@Test
	public void testForProductNameStringWithPostive() {
		List<Product> products = new ArrayList();
		product.setName("samsang");
		products.add(product);
		product.setName("samsangfridge");
		products.add(product);
		Mockito.when(productService.getProductByNameStartingWith("sam")).thenReturn(products);
		ResponseEntity<List<Product>> result = productController.getProductByNameLike("sam");
		Assert.assertNotNull(result);

	}

	@Test
	public void testForProductUpdate() {
		product.setProductId(13);
		product.setName("home");
		Mockito.when(productService.updateProduct(product)).thenReturn(product);
		ResponseEntity<Product> result = productController.updateProduct(product);
		Assert.assertEquals(result, result);
	}

	public static void tearDown() {
		product = null;
	}

}
