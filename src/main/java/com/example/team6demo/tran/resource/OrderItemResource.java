package com.example.team6demo.tran.resource;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString(callSuper = true)
public class OrderItemResource extends BaseResource {
	private ProductResource product;
	private Integer quantity;
	private BigDecimal price;
}
