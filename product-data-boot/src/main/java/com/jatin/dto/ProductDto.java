package com.jatin.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProductDto {

	@Min(value = 99, message = "Product code must be 99 or above")
	private int code;
	@Size(min = 5, message = "Product name must be least 5 char")
	private String name;
	@DecimalMin(value = "99.00", message = "Product price must be 99.00 or above")
	@DecimalMax(value = "999.99", message = "Product price must be 99.00 or less")
	private double price;
	@NotNull(message = "Product category cannot be null")
	private String category;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
