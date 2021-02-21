package com.SLiottaDev.Models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;


@Entity
@Table(name="Orders")
public class Order implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Column(name = "OrderId" )
	private Long OrderId;
	
	@Column(name = "DateArrived" )
	private LocalDate dateArrived;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();

	public Order() {
		super();
	}

	public Order(Long orderId, LocalDate dateArrived) {
		OrderId = orderId;
		this.dateArrived = dateArrived;
	}

	public Long getOrderId() {
		return OrderId;
	}

	public void setOrderId(Long orderId) {
		OrderId = orderId;
	}

	public LocalDate getDateArrived() {
		return dateArrived;
	}

	public void setDateArrived(LocalDate dateArrived) {
		this.dateArrived = dateArrived;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Order [OrderId=" + OrderId + ", dateArrived=" + dateArrived + "]";
	}

}
