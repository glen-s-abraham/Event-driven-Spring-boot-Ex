package com.ms.estore.ProductService.core.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private String title;
	private Double price;
	private Integer qty;
}
