package com.samaspace.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.Type;


@Entity
public class Product implements Serializable{

	
	
	private Long idProduct;
	private String descriptionProduct;
	private double priceProduct;
	private int amountProduct;
	
	
	
	
	private Category category;
	
	
	
	public Product(String descriptionProduct, double priceProduct, int amountProduct) {
		super();
		this.descriptionProduct = descriptionProduct;
		this.priceProduct = priceProduct;
		this.amountProduct = amountProduct;
	}
	


	public Product(String descriptionProduct, double priceProduct, int amountProduct, Category category) {
		super();
		this.descriptionProduct = descriptionProduct;
		this.priceProduct = priceProduct;
		this.amountProduct = amountProduct;
		this.category = category;
	}







	public Product() {
		super();
	}
	
	
	

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	@Column(length = 130)
	public String getDescriptionProduct() {
		return descriptionProduct;
	}

	public void setDescriptionProduct(String descriptionProduct) {
		this.descriptionProduct = descriptionProduct;
	}

	public double getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(double priceProduct) {
		this.priceProduct = priceProduct;
	}

	public int getAmountProduct() {
		return amountProduct;
	}

	public void setAmountProduct(int amountProduct) {
		this.amountProduct = amountProduct;
	}


	@ManyToOne
	@JoinColumn(name = "idCateg")
	public Category getCategory() {
		return category;
	}



	public void setCategory(Category category) {
		this.category = category;
	}

	
	
}
