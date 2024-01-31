package com.example.team6demo.mapper;



import com.example.team6demo.model.Product;
import com.example.team6demo.tran.resource.ProductResource;
import org.junit.Ignore;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = Ignore.class)
public interface ProductMapper extends BaseMapper<Product, ProductResource> {
}
