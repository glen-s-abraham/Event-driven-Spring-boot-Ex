package com.ms.estore.ProductService.commands;




import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Builder;
import lombok.Data;

//command format <Verb><Noun>Command
//CreateProductCommand

@Data
@Builder
public class CreateProductCommand {
	@TargetAggregateIdentifier
	private final String productId;
	private final String title;
	private final Double price;
	private final Integer qty;
	
}
