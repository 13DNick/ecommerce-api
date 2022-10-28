package com.nikitadev.ecommercestore.dto;

public class PurchaseResponse {
	
	private String orderTrackingObject;

	public PurchaseResponse() {
		
	}
	
	public PurchaseResponse(String orderTrackingObject) {
		this.orderTrackingObject = orderTrackingObject;
	}

	public String getOrderTrackingObject() {
		return orderTrackingObject;
	}

	public void setOrderTrackingObject(String orderTrackingObject) {
		this.orderTrackingObject = orderTrackingObject;
	}

	@Override
	public String toString() {
		return "PurchaseResponse [orderTrackingObject=" + orderTrackingObject + "]";
	}
	
}
