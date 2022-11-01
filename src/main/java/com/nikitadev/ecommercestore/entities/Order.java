package com.nikitadev.ecommercestore.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="`order`")
public class Order {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(hidden=true)
	private int id;
	
	@Column(name="order_tracking_number")
	@ApiModelProperty(hidden=true)
	private String orderTrackingNumber;
	
	@Column(name="total_quantity")
	private int totalQuantity;
	
	@Column(name="total_price")
	private double totalPrice;
	
	@Column(name="date_created")
	@CreationTimestamp
	@ApiModelProperty(hidden=true)
	private Date dateCreated;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="order")
	@ApiModelProperty(hidden=true)
	private Set<OrderItem> orderItems;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	@ApiModelProperty(hidden=true)
	private Customer customer;
	
	public Order() {
		
	}

	public Order(String orderTrackingNumber, int totalQuantity, double totalPrice, Date dateCreated) {
		this.orderTrackingNumber = orderTrackingNumber;
		this.totalQuantity = totalQuantity;
		this.totalPrice = totalPrice;
		this.dateCreated = dateCreated;
	}
	
	public void add(OrderItem item) {
		if(item != null) {
			if(this.orderItems == null) {
				this.orderItems = new HashSet<>();
			}
			
			orderItems.add(item);
			item.setOrder(this);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderTrackingNumber() {
		return orderTrackingNumber;
	}

	public void setOrderTrackingNumber(String orderTrackingNumber) {
		this.orderTrackingNumber = orderTrackingNumber;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
