package com.example.team6demo.services;


import com.example.team6demo.model.Category;
import com.example.team6demo.model.Product;
import com.example.team6demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {
	private final ProductRepository productRepository;
	private final CategoryService categoryService;

	@Override
	protected JpaRepository<Product, Long> getRepository() {
		return productRepository;
	}

	@Override
	public Product findBySerial(final String serial) {
		return productRepository.findBySerial(serial);
	}

	@Override
	public Product create(final Product product, final Long categoryId) {
		var category = categoryService.get(categoryId);
		product.setCategory((Category) category);
		return productRepository.save(product);
	}
}
