package com.product.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.product.model.Product;
import com.product.service.ProductService;
import com.product.service.UserLoginService;


@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	loginController logincontroller;
	@Autowired
	UserLoginService userloginService;
	boolean result = false;
	@GetMapping(value = "/product")
	public ResponseEntity<Object> getAllProduct(@RequestParam("name") String name) {
		  if (userloginService.loginValidation(name)) {
	            List<Product> products = productService.getAllProducts();
	            return new ResponseEntity<Object>(products, HttpStatus.OK);
	        }
	        return new ResponseEntity<Object>("user not logged in", HttpStatus.NOT_ACCEPTABLE);
	    }
	

	@GetMapping(value = "/productex/{product}")
	public ResponseEntity<Product> getProductById(@PathVariable("product") int productId) {
		Product product = productService.getProductById(productId);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@PostMapping(value = "/product")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product product1 = productService.addProduct(product);
		return new ResponseEntity<Product>(product1, HttpStatus.OK);
	}

	@PutMapping(value = "/product")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		Product product2 = productService.updateProduct(product);
		return new ResponseEntity<Product>(product2, HttpStatus.OK);
	}

	@DeleteMapping(value = "/product/{product}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("product") int productId) {
		productService.deleteProduct(productId);
		return new ResponseEntity<String>("product delected", HttpStatus.OK);
	}

	@GetMapping(value = "/product1/{product1}")
	public ResponseEntity<Product> getProductByName(@PathVariable("product1") String name) {
		Product product = productService.getProductByName(name);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@GetMapping(value = "/product2/{product2}")
	public ResponseEntity<List<Product>> getProductByNameLike(@PathVariable("product2") String name) {
		List<Product> product = productService.getProductByNameStartingWith(name);
		return new ResponseEntity<List<Product>>(product, HttpStatus.OK);

	}

	@GetMapping(value = "/product3/{product}/{producte}")
	public ResponseEntity<Product> getProductByNameAndPrice(@PathVariable("product") String name,
			@PathVariable("producte") double price) {
		Product product = productService.getProductByNameAndPrice(name, price);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@GetMapping(value = "/product4/{productt}")
	public ResponseEntity<Product> getProductByPrice(@PathVariable("productt") double price) {
		Product product = productService.getProductByPrice(price);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
}