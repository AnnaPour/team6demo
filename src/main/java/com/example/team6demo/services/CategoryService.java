package com.example.team6demo.services;

import gr.codelearn.spring.showcase.app.model.Category;

public interface CategoryService extends BaseService<Category, Long> {
	Category findByDescription(String description); // (1)
}
