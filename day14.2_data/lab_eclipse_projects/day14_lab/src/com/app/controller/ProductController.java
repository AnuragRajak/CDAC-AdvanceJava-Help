package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IProductDao;
import com.app.pojos.Product;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private IProductDao dao;

	public ProductController() {
		System.out.println("in product controller constr");
	}

	// REST request handling method to send product details by id.
	@GetMapping("/{pid}")
	public ResponseEntity<?> getProductDetails(@PathVariable int pid) {
		System.out.println("in get prod " + pid);
		Product p = dao.getById(pid);
		if (p != null) // product found
			return new ResponseEntity<Product>(p, HttpStatus.OK);
		// product not found
		return new ResponseEntity<String>("Invalid product id", HttpStatus.NOT_FOUND);
	}

	// REST request handling method for creating a new product
	@PostMapping
	public ResponseEntity<String> createProduct(@RequestBody Product p) {
		System.out.println("in create propduct " + p);
		try {
			return new ResponseEntity<String>(dao.createNewProduct(p), HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
