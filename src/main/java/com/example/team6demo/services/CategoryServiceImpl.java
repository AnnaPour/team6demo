package com.example.team6demo.services;


import com.example.team6demo.model.Category;
import com.example.team6demo.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {
	private final CategoryRepository categoryRepository;

	@Override
	protected JpaRepository<Category, Long> getRepository() {
		return categoryRepository;
	}

	@Override
	public Category findByDescription(final String description) {
		return categoryRepository.findByDescription(description);
	}
}
