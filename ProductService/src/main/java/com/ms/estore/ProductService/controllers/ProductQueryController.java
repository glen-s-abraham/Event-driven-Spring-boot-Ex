package com.ms.estore.ProductService.controllers;

import java.util.List;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ms.estore.ProductService.pojos.ProductRest;
import com.ms.estore.ProductService.queries.FindProductsQuery;

@RestController
@RequestMapping("/products")
public class ProductQueryController {
	
	@Autowired
	QueryGateway queryGateway;
	
	@GetMapping
	public List<ProductRest> getProducts() {
		FindProductsQuery findProductsQuery = new FindProductsQuery();
		List<ProductRest> products=queryGateway.query(findProductsQuery, ResponseTypes.multipleInstancesOf(ProductRest.class)).join();
		return products;
	}
}
