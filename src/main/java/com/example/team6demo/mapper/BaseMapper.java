package com.example.team6demo.mapper;

import com.example.team6demo.model.Category;
import com.example.team6demo.tran.resource.CategoryResource;

import java.util.List;

public interface BaseMapper<D, R> extends BaseMapper<Category, CategoryResource> {
    R toResource(D domain);

    List<R> toResources(List<D> domains);

    D toDomain(R resource);

    List<D> toDomains(List<R> resources);
}
