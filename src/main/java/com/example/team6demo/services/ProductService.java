package com.example.team6demo.services;

import gr.codelearn.spring.showcase.app.model.Product;

public interface ProductService extends BaseService<Product, Long> {
	Product findBySerial(String serial);

	Product create(Product product, Long categoryId);
}
