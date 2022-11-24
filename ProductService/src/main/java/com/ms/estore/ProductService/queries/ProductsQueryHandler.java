package com.ms.estore.ProductService.queries;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.estore.ProductService.core.entities.Productentity;
import com.ms.estore.ProductService.core.repositories.ProductRepository;
import com.ms.estore.ProductService.pojos.ProductRest;

@Component
public class ProductsQueryHandler {
	
	ProductRepository productRepository;
	
	@Autowired
	public ProductsQueryHandler(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@QueryHandler
	public List<ProductRest> findProducts(FindProductsQuery findProductsQuery){
		List <ProductRest> products = new ArrayList<>();
		List<Productentity> productEntites=productRepository.findAll();
		productEntites.forEach(entity->{
			ProductRest product = new ProductRest(); 
			BeanUtils.copyProperties(entity, product);
			products.add(product);
		});
		return products;
	}
	
}
