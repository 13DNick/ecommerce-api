package com.nikitadev.ecommercestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nikitadev.ecommercestore.dto.Purchase;
import com.nikitadev.ecommercestore.dto.PurchaseResponse;
import com.nikitadev.ecommercestore.service.CheckoutService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/checkout")
public class CheckoutController {
	
	@Autowired
	private CheckoutService checkoutService;
	
	@PostMapping("/purchase")
	public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
		PurchaseResponse purchaseResponse = this.checkoutService.placeOrder(purchase);
		return purchaseResponse;
	}
	
}
