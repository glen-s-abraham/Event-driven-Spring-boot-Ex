package com.ms.estore.ProductService.pojos;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class Product {
	@NotBlank(message="Product's title is a required field")
	private String title;
	@Min(value=1,message="Price cannot be lower than 1")
	private Double price;
	@Min(value=1,message="Price cannot be lower than 1")
	@Max(value=5,message="Qty cannot be greater than 5")
	private Integer qty;
}
