package com.example.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@Column(name = "product_id")
	private String productId;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "category")
	private String productCategory;
	
	@Column(name = "subcategory")
	private String productSubCategory;
	
	@Column(name = "brand")
	private String productBrand;
	
	@Column(name = "price")
	private double productPrice;
	
	@Column(name = "image")
	private String productImage;
	
	@Column(name = "available")
	private String productAvailable;
	
	public Product(String productId, String productName, String productCategory, String productSubCategory,
			String productBrand, double productPrice, String productImage, String productAvailable) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productSubCategory = productSubCategory;
		this.productBrand = productBrand;
		this.productPrice = productPrice;
		this.productImage = productImage;
		this.productAvailable = productAvailable;
	}
	
	public Product() {
		super();
	}

	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductSubCategory() {
		return productSubCategory;
	}
	public void setProductSubCategory(String productSubCategory) {
		this.productSubCategory = productSubCategory;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getProductAvailable() {
		return productAvailable;
	}
	public void setProductAvailable(String productAvailable) {
		this.productAvailable = productAvailable;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCategory="
				+ productCategory + ", productSubCategory=" + productSubCategory + ", productBrand=" + productBrand
				+ ", productPrice=" + productPrice + ", productImage=" + productImage + ", productAvailable="
				+ productAvailable + "]";
	}	
}
