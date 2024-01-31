package com.example.team6demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCT_CATEGORIES")
@SequenceGenerator(name = "idGenerator", sequenceName = "PRODUCT_CATEGORIES_SEQ", initialValue = 1, allocationSize = 1)
public class ProductCategory extends BaseModel {

    @Setter
    @NotNull
    @Column(length = 50, nullable = false)
    private String categoryName;
    private String description;
    @OneToMany(mappedBy = "productCategory", cascade = CascadeType.ALL)
    private List<Product> products;


}
