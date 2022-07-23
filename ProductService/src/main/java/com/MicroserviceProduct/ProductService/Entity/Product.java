package com.MicroserviceProduct.ProductService.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@Column(name = "Product Id")
	private long  id;
	
	@Column(name = "Product_Name")
	private String productName;
	
	@Column(name="Price")
	private int price;
	
	public Product() {
		
	}

	public Product(long id, String productName, int price) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", price=" + price + "]";
	}
	

}
