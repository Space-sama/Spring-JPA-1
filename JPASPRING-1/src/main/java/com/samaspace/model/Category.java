package com.samaspace.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;

@Entity
public class Category implements Serializable{
	

	@Id
	@GeneratedValue
	@Column(name = "idC",length = 11)
	private Long idCateg;
	
	@Column(length = 90)
	private String nameCateg;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category", fetch = FetchType.LAZY)
	private Collection<Product> products;
	
	public Category(String nameCateg) {
		super();
		this.nameCateg = nameCateg;
	}

	public Category() {
		super();
	}
	
	
	public Long getIdCateg() {
		return idCateg;
	}

	public void setIdCateg(Long idCateg) {
		this.idCateg = idCateg;
	}

	public Collection<Product> getProducts() {
		return products;
	}

	public void setProducts(Collection<Product> products) {
		this.products = products;
	}

	public String getNameCateg() {
		return nameCateg;
	}

	public void setNameCateg(String nameCateg) {
		this.nameCateg = nameCateg;
	}
	
	
	
	
	
	
	
}
