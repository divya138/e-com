package com.product.controller.exception;

public class InvailUserException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	@Override
	public String getMessage() {
		return "product Exception is called";
	}

}
