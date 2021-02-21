package com.SLiottaDev.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Column(name = "UserId" )
	private Long userId;
	
	@Column(name = "Email")
	private String mail;
	
	@Column(name = "UserName" )
	private String userName;
	
	@Column(name = "Password" )
	private String password;
	
	@Column(name = "Name" )
	private String name;

	@Column(name = "LastName" )
	private String lastName;
	
	@Column(name = "Address" )
	private String address;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ImageId")
	private Imagen imagen;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Cart> carts = new ArrayList<Cart>();

	public User() {
	}

	public User(String name, String lastName, String address, Imagen imagen, String userName, String password, String mail) {
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.imagen = imagen;
		this.userName = userName;
		this.password = password;
		this.mail = mail;
	}

	public Imagen getImagen() {
		return imagen;
	}
	
	public void setImagen(Imagen imagen) {
		this.imagen = imagen;
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public List<Cart> getCarts() {
		return carts;
	}
	
	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", name=" + name
				+ ", lastName=" + lastName + ", address=" + address + ", E-Mail=" + mail + ", imagen=" + imagen + "]";
	}
	
}
