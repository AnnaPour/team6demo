package com.example.team6demo.services;

import com.example.team6demo.model.Store;

public interface StoreService extends BaseService<Store, Long> {
    Store findById(String id);

    Store create(Store store,  Long Id);
}

