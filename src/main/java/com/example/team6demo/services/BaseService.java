package com.example.team6demo.services;


import com.example.team6demo.model.BaseModel;

import java.util.List;

public interface BaseService<T extends BaseModel, K> {
	T create(T item);

	List<T> createAll(List<T> items);

	List<T> createAll(T... items);

	void update(T item);

	void delete(T item);

	void deleteById(K id);

	Object get(K id);

	boolean exists(T item);

	List<T> findAll();

	Long count();
}
