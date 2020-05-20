package com.product.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private int productId;
	private String name;
	private String description;
	private double price;
	private LocalDate date;

	public Product(String name, String description, double price, LocalDate date) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.date = date;
	}

	public Product(int productId, String name, String description, double price, LocalDate date) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.date = date;
	}

	public Product() {
		super();
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", description=" + description + ", price="
				+ price + ", date=" + date + "]";
	}

}
