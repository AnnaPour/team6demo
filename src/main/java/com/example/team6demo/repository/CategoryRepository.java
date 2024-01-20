package com.example.team6demo.repository;

import gr.codelearn.spring.showcase.app.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	Category findByDescription(String description);
}
