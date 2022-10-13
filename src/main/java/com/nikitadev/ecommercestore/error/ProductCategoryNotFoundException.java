package com.nikitadev.ecommercestore.error;

public class ProductCategoryNotFoundException extends RuntimeException{
	
	public ProductCategoryNotFoundException() {
	}

	public ProductCategoryNotFoundException(String message) {
		super(message);
	}

	public ProductCategoryNotFoundException(Throwable cause) {
		super(cause);
	}

	public ProductCategoryNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProductCategoryNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
}
