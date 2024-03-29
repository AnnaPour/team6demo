package com.example.team6demo.helper;


import com.example.team6demo.base.BaseComponent;
import com.example.team6demo.model.Product;
import com.example.team6demo.model.Category;
import com.example.team6demo.model.Customer;
import com.example.team6demo.model.ProductCategory;
import com.example.team6demo.services.CategoryService;
import com.example.team6demo.services.CustomerService;
import com.example.team6demo.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

@Component
@Profile("generate-catalog-customers")


public class CatalogCustomerSampleContentCreator extends BaseComponent implements CommandLineRunner {
	private final ProductService productService;
	private final CategoryService categoryService;
	private final CustomerService customerService;

    public CatalogCustomerSampleContentCreator(ProductService productService, CategoryService categoryService, CustomerService customerService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.customerService = customerService;
    }

    @Override
	public void run(String... args) throws Exception {
		Category newCategory = categoryService.create(Product.builder().serial("Product").build().getCategory());
		logger.info("Created {}.", newCategory);

		List<Product> products = List.of(
				Product.builder().serial("SN1000-0001").name("Americano").productCategory(ProductCategory.COFFEE)
					   .price(BigDecimal.valueOf(2.00)).category(newCategory).build(),
				Product.builder().serial("SN1000-0002").name("Καλαμακι κοτοπουλο").productCategory(ProductCategory.SOUVLAKI)
					   .price(BigDecimal.valueOf(2.50)).category(newCategory).build(),
				Product.builder().serial("SN1100-0001").name("Burrito").productCategory(ProductCategory.MEXICAN)
					   .price(BigDecimal.valueOf(4.60)).category(newCategory).build(),
				Product.builder().serial("SN1100-0002").name("Margarita").productCategory(ProductCategory.PIZZA)
					   .price(BigDecimal.valueOf(6.99)).category(newCategory).build(),
				Product.builder().serial("SN1200-0001").name("BBQ Burger").productCategory(ProductCategory.BURGER)
					   .price(BigDecimal.valueOf(8.99)).category(newCategory).build()
);

		var productsCreated = productService.createAll(products);
		logger.info("Created {} products.", productsCreated.size());
		productsCreated.stream()
					   .sorted(Comparator.comparing(Product::getId))
					   .forEach(p -> logger.debug("{}. {}", p.getId(), p));

		List<Customer> customersCreated = customerService.createAll(List.of(
				Customer.builder().email("alexia.tsrk@gmailx.com")
						.firstname("Alexia").lastname("Tsirikou")
						.address("345, VOLOS")
						.age(23).build(),
				Customer.builder().email("anna.pourpouri@gmailx.com")
						.firstname("Anna").lastname("Pourpouri")
						.address("123 THESSALONIKI").age(29).build(),
				Customer.builder().email("melina.vasil@gmailx.com")
						.firstname("Melina").lastname("Vasilopoulou")
						.address("890, LONDON")
						.age(28).build(),
				Customer.builder().email("c.giannacoulis@codehub.gr")
						.firstname("Constantinos").lastname("Giannacoulis")
						.address("678, ATHENS")
						.age(47).build()
		));





		logger.info("Created {} customers.", customersCreated.size());
		customersCreated.stream()
						.sorted(Comparator.comparing(Customer::getId))
						.forEach(c -> logger.debug("{}. {}", c.getId(), c));
	}
}
