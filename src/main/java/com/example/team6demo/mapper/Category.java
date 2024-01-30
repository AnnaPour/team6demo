package com.example.team6demo.mapper;


import com.example.team6demo.model.model.Category;
import com.example.team6demo.tran.resource.CategoryResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = IgnoreUnmappedMapperConfig.class)
interface CategoryMapper extends BaseMapper<Category, CategoryResource> {
}

