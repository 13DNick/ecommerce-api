package com.nikitadev.ecommercestore.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductCategoryExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ProductCategoryErrorResponse> handleException(ProductCategoryNotFoundException e){
		ProductCategoryErrorResponse error = new ProductCategoryErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ProductCategoryErrorResponse> handleAllException(Exception e){
		ProductCategoryErrorResponse error = new ProductCategoryErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
}
