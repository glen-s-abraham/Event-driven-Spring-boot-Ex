package com.ms.estore.ProductService.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
	@PostMapping
	public String createProduct() {
		return "HTTP POST Handler";
	}
	
	@GetMapping
	public String getProduct() {
		return "HTTP GET Handler";
	}
	
	@PutMapping
	public String updateProduct() {
		return "HTTP PUT Handler";
	}
	
	@DeleteMapping
	public String deleteProduct() {
		return "HTTP DEL Handler";
	}
}
