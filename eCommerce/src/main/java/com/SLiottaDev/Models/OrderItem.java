package com.SLiottaDev.Models;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="OrderItems")
public class OrderItem implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Column(name = "OrderItemId" )
	private Long orderItemId;
	
	@Column(name = "Cantidad" )
	private Integer cantidad;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OrderId")
	private Order order;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn (name = "ProductId")
	private Product producto; 

	public OrderItem() {
	}

	public OrderItem(Long orderItemId, Integer cantidad, Order order, Product producto) {
		this.orderItemId = orderItemId;
		this.cantidad = cantidad;
		this.order = order;
		this.producto = producto;
	}

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	public void setProducto(Product producto) {
		this.producto = producto;
	}
	
	public Product getProducto() {
		return producto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", cantidad=" + cantidad + ", order=" + order + "]";
	}

	
}
