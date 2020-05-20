package com.product.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ProductExceptionCntroller extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value = ProductNotfoundException.class)
	public ResponseEntity<Object> exception(ProductNotfoundException exception) {
		return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = InvailUserException.class)
	public ResponseEntity<Object> exception(InvailUserException exception) {
		return new ResponseEntity<>("user not found", HttpStatus.NOT_FOUND);
	}
}
