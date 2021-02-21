package com.SLiottaDev.Models;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Products")
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Column(name = "ProductId" )	
	private Long ProductId;

	@Column(name = "Descripcion" )	
	private String Descripcion;

	@Column(name = "Precio" )	
	private Double Precio;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="ImageId")
	private Imagen imagen;
	
	public Product() {
	}

	public Product(Long productId, String descripcion, Double precio, Imagen imagen) {
		ProductId = productId;
		Descripcion = descripcion;
		Precio = precio;
		this.imagen = imagen;
	}

	public Long getProductId() {
		return ProductId;
	}

	public void setProductId(Long productId) {
		ProductId = productId;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public Double getPrecio() {
		return Precio;
	}

	public void setPrecio(Double precio) {
		Precio = precio;
	}

	public Imagen getImagen() {
		return imagen;
	}

	public void setImagen(Imagen imagen) {
		this.imagen = imagen;
	}
	
	@Override
	public String toString() {
		return "Product [ProductId=" + ProductId + ", Descripcion=" + Descripcion + ", Precio=" + Precio + ", imagen="
				+ imagen + "]";
	}
	
}
