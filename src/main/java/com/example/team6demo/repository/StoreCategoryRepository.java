package com.example.team6demo.repository;

import com.example.team6demo.model.StoreCategory;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreCategoryRepository extends BaseRepository<StoreCategory, Long> {
    StoreCategory findBycategoryName(final String categoryName);
}