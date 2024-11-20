package com.jatin.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jatin.dto.ProductDto;
import com.jatin.entity.Product;
import com.jatin.service.ProductService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@RestController
@RequestMapping(value = "/product")
public class ProductController {
	@Autowired
	private ProductService service;

	@PostMapping(value = "/add", consumes = "application/json")
	public ResponseEntity<String> add(@RequestBody @Valid ProductDto p) {
		// TODO: process POST request
		service.save(p); 
		return new ResponseEntity<String>("Product added", HttpStatus.OK);
	}

	@GetMapping(value = "/list", produces = "application/json")
	public ResponseEntity<List<Product>> list() {
		return new ResponseEntity<List<Product>>(service.list(), HttpStatus.OK);
	}

	@GetMapping(value = "/{code}")
	public ResponseEntity<Product> find(@PathVariable int code) {
		return new ResponseEntity<Product>(service.getByCode(code), HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{code}")
	public ResponseEntity<String> remove(@PathVariable int code) {
		service.delete(code);
		return new ResponseEntity<>("Product deleted", HttpStatus.OK);
	}

	@GetMapping(value = "/category/{cat}")
	public ResponseEntity<List<Product>> listByCategory(@PathVariable String cat) {
		return new ResponseEntity<List<Product>>(service.listByCategory(cat), HttpStatus.OK);
	}

	@GetMapping(value = "/price")
	public ResponseEntity<List<Product>> listByPriceRange(@RequestParam double min, @RequestParam double max) {
		return new ResponseEntity<List<Product>>(service.listByPriceRange(min, max), HttpStatus.OK);
	}

	@GetMapping(value = "/price-low-to-high")
	public ResponseEntity<List<Product>> listByPriceLowToHigh() {
		return new ResponseEntity<List<Product>>(service.listByPriceLowToHigh(), HttpStatus.OK);
	}
}
