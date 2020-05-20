package com.product.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner.Silent;

import com.product.controller.exception.ProductNotfoundException;
import com.product.model.Product;
import com.product.repositroy.ProductRepositroy;

@RunWith(Silent.class)

public class ProductServiceTest {
	@InjectMocks
	ProductServiceImpl productServiceImpl;
	@Mock
	ProductRepositroy productRepositroy;
	static Product product = null;

	@BeforeClass
	public static void setUp() {
		product = new Product();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testForFinfByIdForPostivte() {
		product.setProductId(2);
		product.setName("laptop");
		Mockito.when(productRepositroy.getOne(Mockito.anyInt())).thenReturn(product);
		Product product1 = productServiceImpl.getProductById(2);
		Assert.assertNotNull(product1);
		Assert.assertEquals(2, product1.getProductId());
		}

	@SuppressWarnings("deprecation")
	@Test
	public void testGetAllProductsForPostivte() {
		List<Product> products = new ArrayList();
		product.setName("phone");
		product.setPrice(5678);
		products.add(product);

		Mockito.when(productRepositroy.findAll()).thenReturn(products);

		Assert.assertEquals(1, products.size());

	}

	@Test
	public void testForProductNameStringWithPostiveService() {
		List<Product> products = new ArrayList();
		product.setName("LG");
		products.add(product);
		product.setName("LGfridge");
		products.add(product);
		Mockito.when(productRepositroy.getProductByNameStartingWith("sam")).thenReturn(products);
		List<Product> result = productServiceImpl.getProductByNameStartingWith("LG");
		Assert.assertNotNull(result);
	}

	@Test
	public void testForFinfByNameForPostivte() {
		product.setProductId(3);
		product.setName("AC");
		Mockito.when(productRepositroy.getProductByName(Mockito.anyString())).thenReturn(product);
		Product product1 = productServiceImpl.getProductByName("AC");
		Assert.assertNotNull(product1);
		Assert.assertEquals("AC", product1.getName());

	}
	@Test(expected = ProductNotfoundException.class)
	public void testFinfByNameForException() {
		product.setProductId(4);
		product.setName("sam");
		Mockito.when(productRepositroy.getProductByName("sam")).thenReturn(product);
		Product product1 = productServiceImpl.getProductByName("AC");	
	}
	@AfterClass
	public static void tearDown() {
		product = null;

	}

}
