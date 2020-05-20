package com.product.model;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProductTest {
	static Product product=null;
	@BeforeClass
	public  static void setUp() {
		product=new Product();
	}
	@Test
	public void testForName() {
		product.setName("divya");
		Assert.assertEquals("divya123", "divya", "divya");
	}
	@Test
	public void testForId() {
		product.setProductId(4);
		Assert.assertEquals(4, 4);
	}
	@Test
	public void testForDescription() {
		product.setProductId(5);
		product.setName("Tv");
		product.setDescription("enteriment");
		Assert.assertEquals("test for string", "enteriment", "enteriment");
	}
	@AfterClass
	public static  void  tearDown() {
		product=null;
	}

}
