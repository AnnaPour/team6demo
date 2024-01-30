package com.example.team6demo.services;

import com.example.team6demo.model.Product;
import gr.codelearn.spring.showcase.app.model.Product;

import java.util.List;

public interface ProductService extends BaseService<Product, Long> {
	Product findBySerial(String serial);

	Product create(Product product, Long categoryId);

	List<Product> createAll(List<Product> products);
}
