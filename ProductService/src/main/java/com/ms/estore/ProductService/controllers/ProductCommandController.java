package com.ms.estore.ProductService.controllers;

import java.util.UUID;

import javax.validation.Valid;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.estore.ProductService.commands.CreateProductCommand;
import com.ms.estore.ProductService.pojos.Product;

@RestController
@RequestMapping("/products")
public class ProductCommandController {
	
	
	private final CommandGateway commandGateway;
	
	@Autowired
	public ProductCommandController(CommandGateway commandGateway) {
		this.commandGateway = commandGateway;
	}

	@PostMapping
	public String createProduct(@Valid @RequestBody Product product) {
		CreateProductCommand createProductCommand= CreateProductCommand.builder()
			.title(product.getTitle())
			.price(product.getPrice())
			.qty(product.getQty())
			.productId(UUID.randomUUID().toString())
			.build();
		String res;
		try {
			res=commandGateway.sendAndWait(createProductCommand);
		}catch (Exception e) {
			res = e.getLocalizedMessage();
		}
		return res;
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
