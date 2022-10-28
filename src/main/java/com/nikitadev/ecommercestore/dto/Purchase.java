package com.nikitadev.ecommercestore.dto;

import java.util.Set;

import com.nikitadev.ecommercestore.entities.Customer;
import com.nikitadev.ecommercestore.entities.Order;
import com.nikitadev.ecommercestore.entities.OrderItem;

public class Purchase {
	
	private Customer customer;
	private Order order;
	private Set<OrderItem> orderItems;
	
	public Purchase() {
		
	}

	public Purchase(Customer customer, Order order, Set<OrderItem> orderItems) {
		this.customer = customer;
		this.order = order;
		this.orderItems = orderItems;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	
}
