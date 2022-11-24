package com.ms.estore.ProductService.aggregators;



import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.ms.estore.ProductService.commands.CreateProductCommand;
import com.ms.estore.ProductService.core.events.ProductCreatedEvent;

@Aggregate
public class ProductAggregator {
	
	@AggregateIdentifier
	private String productId;
	private String title;
	private Double price;
	private Integer qty;
	
	public ProductAggregator() {}
	
	@CommandHandler
	public ProductAggregator(CreateProductCommand createProductCommand) {
		//Validate create product command
		if(createProductCommand.getPrice()<=0) {
			throw new IllegalArgumentException("Price cannot be less or eqal than zero");
		}
		if(createProductCommand.getTitle().isBlank()||createProductCommand.getTitle()==null) {
			throw new IllegalArgumentException("Title cannot be empty");
		}
		
		ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent();
		BeanUtils.copyProperties(createProductCommand, productCreatedEvent);
		//dispatch event to all event handlers
		AggregateLifecycle.apply(productCreatedEvent);
	}
	
	@EventSourcingHandler
	public void on(ProductCreatedEvent productCreatedEvent) {
		this.productId = productCreatedEvent.getProductId();
		this.title = productCreatedEvent.getTitle();
		this.price = productCreatedEvent.getPrice();
		this.qty = productCreatedEvent.getQty();
	}
	
}
