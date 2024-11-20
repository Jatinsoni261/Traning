package com.jatin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jatin.dto.ProductDto;
import com.jatin.entity.Product;
import com.jatin.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repo;

	@Override
	public void save(ProductDto p) {
		// TODO Auto-generated method stub
		Product prod = new Product();
		prod.setCode(p.getCode());
		prod.setName(p.getName());
		prod.setCategory(p.getCategory());
		prod.setPrice(p.getPrice());
		repo.save(prod);

	}

	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Product getByCode(int code) {
		// TODO Auto-generated method stub
		return repo.findById(code).get();
	}

	@Override
	public void delete(int code) {
		// TODO Auto-generated method stub
		repo.deleteById(code);
	}

	@Override
	public List<Product> listByCategory(String cat) {
		// TODO Auto-generated method stub
		return repo.findByCategory(cat);
	}

	@Override
	public List<Product> listByPriceRange(double min, double max) {
		// TODO Auto-generated method stub
		return repo.findByPriceBetween(min, max);
	}

	@Override
	public List<Product> listByPriceLowToHigh() {
		// TODO Auto-generated method stub
		return repo.findAllByOrderByPriceAsc();
	}

}
