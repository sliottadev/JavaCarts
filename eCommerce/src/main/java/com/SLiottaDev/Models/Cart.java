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
@Table(name="Carts")
public class Cart implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Column(name = "CartId" )	
	private Long cartId;

	@Column(name = "Description" )	
	private String description;
	
	@Column(name = "Type" )	
	private Character type;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserId")
	private User usuario;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "OrderId")
	private Order order;
	
	
	public Cart() {
	}

	public Cart(Long cartId, String description, Character type, User usuario, Order order) {
		this.cartId = cartId;
		this.description = description;
		this.type = type;
		this.usuario = usuario;
		this.order = order;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Character getType() {
		return type;
	}

	public void setType(Character type) {
		this.type = type;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
	
	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Carts [cartId=" + cartId + ", description=" + description + ", type=" + type + ", usuario=" + usuario
				+ "]";
	}
	
}
