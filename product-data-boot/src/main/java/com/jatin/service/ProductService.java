package com.jatin.service;

import java.util.List;

import com.jatin.dto.ProductDto;
import com.jatin.entity.Product;

public interface ProductService {

	void save(ProductDto p);

	List<Product> list();

	Product getByCode(int code);

	void delete(int code);

	List<Product> listByCategory(String cat);

	List<Product> listByPriceRange(double min, double max);

	List<Product> listByPriceLowToHigh();
}
