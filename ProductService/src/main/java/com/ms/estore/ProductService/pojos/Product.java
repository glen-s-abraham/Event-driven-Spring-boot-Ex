package com.ms.estore.ProductService.pojos;


public class Product {
	private String title;
	private Double price;
	private Integer qty;
	public Product(String title, Double price, Integer qty) {
		this.title = title;
		this.price = price;
		this.qty = qty;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "Product [title=" + title + ", price=" + price + ", qty=" + qty + "]";
	}
	
	
}
