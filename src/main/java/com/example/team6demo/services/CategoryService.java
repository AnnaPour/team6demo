package com.example.team6demo.services;


import com.example.team6demo.model.model.Category;

public interface CategoryService extends BaseService<Category, Long> {
	Category findByDescription(String description); // (1)
}
