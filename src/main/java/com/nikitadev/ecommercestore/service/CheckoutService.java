package com.nikitadev.ecommercestore.service;

import com.nikitadev.ecommercestore.dto.Purchase;
import com.nikitadev.ecommercestore.dto.PurchaseResponse;

public interface CheckoutService {
	
	public PurchaseResponse placeOrder(Purchase purchase);
	
}
