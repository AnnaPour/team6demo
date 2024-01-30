package com.example.team6demo.model;

import com.example.team6demo.model.model.BaseModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "PRODUCTS", indexes = {@Index(columnList = "serial")})
@SequenceGenerator(name = "idGenerator", sequenceName = "PRODUCTS_SEQ", initialValue = 1, allocationSize = 1)
public class Product extends BaseModel {
	@NotNull
	@Column(length = 50, nullable = false)
	private String name;

	@NotNull
	@Column(length = 30, nullable = false, unique = true)
	private String serial;

	@NotNull
	@Column(precision = 10, scale = 2, nullable = false)
	private BigDecimal price;

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	private Category category;

	@ManyToOne(fetch = FetchType.EAGER)
	private ProductCategory productCategory;
}
