package com.ms.estore.ProductService.core.events;

import lombok.Builder;
import lombok.Data;

@Data
public class ProductCreatedEvent {
	private String productId;
	private String title;
	private Double price;
	private Integer qty;
}
