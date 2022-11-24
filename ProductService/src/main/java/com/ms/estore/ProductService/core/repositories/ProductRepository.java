package com.ms.estore.ProductService.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.estore.ProductService.core.entities.Productentity;

public interface ProductRepository extends JpaRepository<Productentity, String> {
	
	Productentity findByProductId(String productId);
	Productentity findByProductIdOrTitle(String productId,String title);
}
