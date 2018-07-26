package com.project.e_commerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "productId")
	private Integer productId;
	
	@NotEmpty(message = "Ürün Adını Doldurunuz!")
	@Column(name = "productName")
	private String productName;
	
	@NotEmpty(message = "Ürün Tipini Doldurunuz!")
	@Column(name = "productType")
	private String productType;

	@Lob
	@Column(name = "productPicture", length=100000)
	private byte[] productPicture;	
	
	@NotEmpty(message = "Ürün Fiyatını Doldurunuz!")
	@Column(name = "productCost")	
	private String productCost;
	
	@NotEmpty(message = "Para Birimini Doldurunuz!")
	@Column(name = "productCostType")	
	private String productCostType;
	
	@NotEmpty(message = "Telefon Numaranızı Doldurunuz!")
	@Size(min = 11, max = 11, message = "Telefon Numarası 11 karakterli olmalıdır!")
	@Column(name = "productUserNumber")	
	private String productUserNumber;
	
	@NotEmpty(message = "Adresinizi Doldurunuz!")
	@Column(name = "productUserAddress")	
	private String productUserAddress;
	
	@NotEmpty(message = "Ürün Açıklamasını Doldurunuz!")
	@Column(name = "productExplanation")	
	private String productExplanation;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "basketId", nullable = false)
	private Basket basket;

	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}

	public byte[] getProductPicture() {
		return productPicture;
	}
	public void setProductPicture(byte[] productPicture) {
		this.productPicture = productPicture;
	}

	public String getProductCost() {
		return productCost;
	}
	public void setProductCost(String productCost) {
		this.productCost = productCost;
	}

	public String getProductCostType() {
		return productCostType;
	}
	public void setProductCostType(String productCostType) {
		this.productCostType = productCostType;
	}

	public String getProductUserNumber() {
		return productUserNumber;
	}
	public void setProductUserNumber(String productUserNumber) {
		this.productUserNumber = productUserNumber;
	}

	public String getProductUserAddress() {
		return productUserAddress;
	}
	public void setProductUserAddress(String productUserAddress) {
		this.productUserAddress = productUserAddress;
	}

	public String getProductExplanation() {
		return productExplanation;
	}
	public void setProductExplanation(String productExplanation) {
		this.productExplanation = productExplanation;
	}

	public Basket getBasket() {
		return basket;
	}
	public void setBasket(Basket basket) {
		this.basket = basket;
	}
}
