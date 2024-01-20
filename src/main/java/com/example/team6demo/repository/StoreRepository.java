package com.example.team6demo.repository;

import com.example.team6demo.model.Store;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends BaseRepository<Store, Long> {
    Store findById(final String id);

}
