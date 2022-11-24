package com.ms.estore.ProductService.pojos;

import lombok.Data;

@Data
public class ProductRest {
		private String productId; 
		private String title;
		private Double price;
		private Integer qty;
}
