package com.ms.estore.ProductService.core.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name="products")
public class Productentity implements Serializable {

	private static final long serialVersionUID = -5061053743918408791L;
	
	@Id
	@Column(unique = true)
	private String productId;
	@Column(unique=true)
	@NotBlank(message="prodcut title is a required field")
	private String title;
	@Min(value = 1,message="Price cannot be lower thanm 1")
	private Double price;
	@Min(value=1,message="Quantity cannot be lower than 1")
	@Max(value=5,message="Quantity cannot be laregr than 5")
	private Integer qty;
}
