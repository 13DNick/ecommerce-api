package com.nikitadev.ecommercestore.service;

import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nikitadev.ecommercestore.dao.CustomerDAO;
import com.nikitadev.ecommercestore.dto.Purchase;
import com.nikitadev.ecommercestore.dto.PurchaseResponse;
import com.nikitadev.ecommercestore.entities.Customer;
import com.nikitadev.ecommercestore.entities.Order;
import com.nikitadev.ecommercestore.entities.OrderItem;

@Service
public class CheckoutServiceImpl implements CheckoutService {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public PurchaseResponse placeOrder(Purchase purchase) {
		
		//retrieve order from dto
		Order order = purchase.getOrder();
		
		//generate tracking number
		String orderTrackingNumber = generateOrderTrackingNumber();
		order.setOrderTrackingNumber(orderTrackingNumber);
		
		//populate order with orderItems
		Set<OrderItem> orderItems = purchase.getOrderItems();
		orderItems.forEach(item -> order.add(item));
		
		//populate customer with order
		Customer customer = purchase.getCustomer();
		customer.add(order);
		
		//save to the database
		this.customerDAO.saveCustomer(customer);
		
		//return a response
		return new PurchaseResponse(orderTrackingNumber);
	}

	private String generateOrderTrackingNumber() {
		return UUID.randomUUID().toString();
	}

}
