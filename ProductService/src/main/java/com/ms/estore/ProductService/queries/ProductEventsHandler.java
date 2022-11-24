package com.ms.estore.ProductService.queries;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.estore.ProductService.core.entities.Productentity;
import com.ms.estore.ProductService.core.events.ProductCreatedEvent;
import com.ms.estore.ProductService.core.repositories.ProductRepository;

@Component
public class ProductEventsHandler {
	
	ProductRepository productRepository;
	
	@Autowired
	public ProductEventsHandler(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@EventHandler
	public void on(ProductCreatedEvent event) {
		Productentity productentity = new Productentity();
		BeanUtils.copyProperties(event, productentity);
		productRepository.save(productentity);
	}
}
